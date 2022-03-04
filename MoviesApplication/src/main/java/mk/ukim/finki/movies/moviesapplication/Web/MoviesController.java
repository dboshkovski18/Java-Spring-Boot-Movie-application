package mk.ukim.finki.movies.moviesapplication.Web;


import mk.ukim.finki.movies.moviesapplication.Model.Movies;
import mk.ukim.finki.movies.moviesapplication.Service.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"/","/movies"})
public class MoviesController {

    private final MoviesServiceImpl moviesService;
    private final ProductionCompanyServiceImpl productionCompanyService;
    private final DirectorServiceImpl directorService;

    public MoviesController(MoviesServiceImpl moviesService, ProductionCompanyServiceImpl productionCompanyService, DirectorServiceImpl directorService) {
        this.moviesService = moviesService;
        this.productionCompanyService = productionCompanyService;
        this.directorService = directorService;
    }

    @GetMapping
    public String getMoviesPage(Model model,@RequestParam(required = false) String search){
        if(search != null) {
            model.addAttribute("movies", moviesService.searchByText(search));
            model.addAttribute("bodyContent", "movies");
            return "master-template";
        }
        model.addAttribute("movies",moviesService.listAll());
        model.addAttribute("topThree",moviesService.listByYear(2019));
        model.addAttribute("bodyContent","movies");
        return  "master-template";
    }

    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("bodyContent","home");
        return "master-template";
    }

    @GetMapping("/movies/{id}")
    public String getMovieInfo(@PathVariable Long id, Model model){
        model.addAttribute("movie",moviesService.findByID(id));
        model.addAttribute("bodyContent","movie-preview");
        return "master-template";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add")
    public String getAddMoviePage(Model model){
        model.addAttribute("directors",directorService.listAll());
        model.addAttribute("companies",productionCompanyService.listAll());
        model.addAttribute("bodyContent","movie-add");
        return "master-template";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public String addMovie(@RequestParam(required = false) Long id,
                           @RequestParam String trailer,
                           @RequestParam String name,
                           @RequestParam String description,
                           @RequestParam int year,
                           @RequestParam String image,
                           @RequestParam Long company,
                           @RequestParam Long director){
        if(name.isEmpty() || description.isEmpty() || image.isEmpty() || company == null || director == null){
            return "redirect:/movies/add";
        }

        if(id != null){
            moviesService.editMovieById(id,name,description,year,image,company,director,trailer);
        }else {
            moviesService.addMovie(name, description, year, company, director, image,trailer);
        }

        return "redirect:/";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        moviesService.deleteByID(id);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/movies/edit/{id}")
    public String editMovie(@PathVariable Long id,Model model){
        Movies movie=moviesService.findByID(id);
        model.addAttribute("movie",movie);   model.addAttribute("directors",directorService.listAll());
        model.addAttribute("companies",productionCompanyService.listAll());

        model.addAttribute("bodyContent","movie-add");

        return "master-template";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

}
