package mk.ukim.finki.movies.moviesapplication.Model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductionCompanyNotFound extends RuntimeException{
    public ProductionCompanyNotFound(Long productionCompany) {
        super("Production company with id:" + productionCompany+" was not found!");
    }
}
