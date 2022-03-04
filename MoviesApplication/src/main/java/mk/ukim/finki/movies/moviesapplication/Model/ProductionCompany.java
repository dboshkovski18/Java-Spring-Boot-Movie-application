package mk.ukim.finki.movies.moviesapplication.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProductionCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Movies> movies;

    public ProductionCompany( String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ProductionCompany() {
    }
}
