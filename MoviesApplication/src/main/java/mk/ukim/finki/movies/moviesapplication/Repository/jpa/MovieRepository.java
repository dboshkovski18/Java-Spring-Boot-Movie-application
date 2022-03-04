package mk.ukim.finki.movies.moviesapplication.Repository.jpa;

import mk.ukim.finki.movies.moviesapplication.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies,Long> {

    List<Movies> findAllByNameContaining(String search);

    List<Movies> findAllByYear(int year);
}
