package mk.ukim.finki.movies.moviesapplication.Repository.jpa;

import mk.ukim.finki.movies.moviesapplication.Model.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany,Long> {
}
