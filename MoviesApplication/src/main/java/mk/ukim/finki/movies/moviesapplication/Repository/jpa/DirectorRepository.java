package mk.ukim.finki.movies.moviesapplication.Repository.jpa;

import mk.ukim.finki.movies.moviesapplication.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
}
