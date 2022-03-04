package mk.ukim.finki.movies.moviesapplication.Service;

import mk.ukim.finki.movies.moviesapplication.Model.Director;
import mk.ukim.finki.movies.moviesapplication.Model.Movies;
import mk.ukim.finki.movies.moviesapplication.Model.ProductionCompany;

import java.util.List;
import java.util.Optional;

public interface MoviesService {

    List<Movies> listAll();

    Movies findByID(Long ID);

    boolean deleteByID(Long ID);

    void addMovie(String name, String description, int year, Long productionCompany, Long director,String image,String trailer);

    void editMovieById(Long id, String name, String description, int year, String image, Long company, Long director,String trailer);

    List<Movies> searchByText(String search);

    List<Movies> listByYear(int year);
}
