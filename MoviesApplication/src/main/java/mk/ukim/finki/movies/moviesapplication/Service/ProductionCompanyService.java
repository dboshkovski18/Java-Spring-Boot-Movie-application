package mk.ukim.finki.movies.moviesapplication.Service;

import mk.ukim.finki.movies.moviesapplication.Model.ProductionCompany;

import java.util.List;

public interface ProductionCompanyService {

    void addProductionCompany(String name,String address);

    boolean deleteProductionCompanyByID(Long id);

    List<ProductionCompany> listAll();

}
