package mk.ukim.finki.movies.moviesapplication.Service;

import mk.ukim.finki.movies.moviesapplication.Model.Director;

import java.util.List;

public interface DirectorService {

    void addDirector(String name,String surname);

    boolean removeDirectorById(Long id);

    List<Director> listAll();

}
