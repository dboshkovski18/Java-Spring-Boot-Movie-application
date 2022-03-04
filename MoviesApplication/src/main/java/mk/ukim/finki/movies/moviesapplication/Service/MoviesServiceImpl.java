package mk.ukim.finki.movies.moviesapplication.Service;


import mk.ukim.finki.movies.moviesapplication.Model.Director;
import mk.ukim.finki.movies.moviesapplication.Model.Exceptions.DirectorNotFound;
import mk.ukim.finki.movies.moviesapplication.Model.Exceptions.MovieNotFoundException;
import mk.ukim.finki.movies.moviesapplication.Model.Exceptions.ProductionCompanyNotFound;
import mk.ukim.finki.movies.moviesapplication.Model.Movies;
import mk.ukim.finki.movies.moviesapplication.Model.ProductionCompany;
import mk.ukim.finki.movies.moviesapplication.Repository.jpa.DirectorRepository;
import mk.ukim.finki.movies.moviesapplication.Repository.jpa.MovieRepository;
import mk.ukim.finki.movies.moviesapplication.Repository.jpa.ProductionCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService{


    private final MovieRepository movieRepository;
    private final ProductionCompanyRepository productionCompanyRepository;
    private final DirectorRepository directorRepository;

    public MoviesServiceImpl(MovieRepository movieRepository, ProductionCompanyRepository productionCompanyRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.productionCompanyRepository = productionCompanyRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Movies> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movies findByID(Long ID) {
        return movieRepository.findById(ID).orElseThrow(() -> new MovieNotFoundException(ID));
    }

    @Override
    public boolean deleteByID(Long ID) {
        if(movieRepository.findById(ID).isPresent()) {
            movieRepository.deleteById(ID);
            return true;
        }else
            return false;

    }

    @Override
    public void addMovie(String name, String description, int year, Long productionCompany, Long director,String image,String trailer) {

        ProductionCompany productionCompany1=productionCompanyRepository.findById(productionCompany).orElseThrow(() -> new ProductionCompanyNotFound(productionCompany));
        Director director1=directorRepository.findById(director).orElseThrow(()->new DirectorNotFound(director));

        Movies movie=new Movies(name,description,year,productionCompany1,director1,image,trailer);

        movieRepository.save(movie);

    }

    @Override
    public void editMovieById(Long id, String name, String description, int year, String image, Long company, Long director,String trailer) {
        Movies movie=movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        ProductionCompany productionCompany=productionCompanyRepository.findById(company).orElseThrow(() -> new ProductionCompanyNotFound(company));
        Director director1=directorRepository.findById(director).orElseThrow(()->new DirectorNotFound(director));


        movie.setName(name);
        movie.setTrailer(trailer);
        movie.setDescription(description);
        movie.setImage(image);
        movie.setYear(year);
        movie.setProductionCompany(productionCompany);
        movie.setDirector(director1);

        movieRepository.save(movie);

    }

    @Override
    public List<Movies> searchByText(String search) {
       return movieRepository.findAllByNameContaining(search);
    }

    @Override
    public List<Movies> listByYear(int year) {
        return movieRepository.findAllByYear(year);
    }
}
