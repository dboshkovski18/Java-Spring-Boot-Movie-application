package mk.ukim.finki.movies.moviesapplication.Service;

import mk.ukim.finki.movies.moviesapplication.Model.Director;
import mk.ukim.finki.movies.moviesapplication.Repository.jpa.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService{

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public void addDirector(String name, String surname) {
        Director director= new Director(name,surname);

        directorRepository.save(director);
    }

    @Override
    public boolean removeDirectorById(Long id) {
        if(directorRepository.findById(id).isPresent()){
            directorRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Director> listAll() {
        return directorRepository.findAll();
    }
}
