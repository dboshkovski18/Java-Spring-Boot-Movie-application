package mk.ukim.finki.movies.moviesapplication.Service;


import mk.ukim.finki.movies.moviesapplication.Model.ProductionCompany;
import mk.ukim.finki.movies.moviesapplication.Repository.jpa.ProductionCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCompanyServiceImpl implements ProductionCompanyService{

    private final ProductionCompanyRepository productionCompanyRepository;

    public ProductionCompanyServiceImpl(ProductionCompanyRepository productionCompanyRepository) {
        this.productionCompanyRepository = productionCompanyRepository;
    }


    @Override
    public void addProductionCompany(String name, String address) {
        ProductionCompany productionCompany=new ProductionCompany(name,address);

        productionCompanyRepository.save(productionCompany);
    }

    @Override
    public boolean deleteProductionCompanyByID(Long id) {

        if(productionCompanyRepository.findById(id).isPresent()){
            productionCompanyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<ProductionCompany> listAll() {
        return productionCompanyRepository.findAll();
    }
}
