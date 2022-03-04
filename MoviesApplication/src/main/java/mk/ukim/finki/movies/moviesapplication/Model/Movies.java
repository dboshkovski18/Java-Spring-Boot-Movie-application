package mk.ukim.finki.movies.moviesapplication.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String trailer;

    private int year;

    private String image;

    @ManyToOne
    private ProductionCompany productionCompany;

    @OneToOne
    private Director director;

    public Movies(String name, String description, int year, ProductionCompany productionCompany,Director director,String image,String trailer) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.image=image;
        this.productionCompany=productionCompany;
        this.director=director;
        this.trailer=trailer;
    }

    public Movies(){}

}
