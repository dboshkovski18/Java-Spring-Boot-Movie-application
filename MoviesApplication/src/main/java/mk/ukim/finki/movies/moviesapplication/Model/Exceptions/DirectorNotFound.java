package mk.ukim.finki.movies.moviesapplication.Model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DirectorNotFound extends RuntimeException{
    public DirectorNotFound(Long director) {
        super("Director with id:" + director+" was not found!");
    }
}