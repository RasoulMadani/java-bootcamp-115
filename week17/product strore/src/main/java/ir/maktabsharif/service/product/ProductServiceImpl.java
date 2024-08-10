package ir.maktabsharif.service.product;

import ir.maktabsharif.entity.Product;
import ir.maktabsharif.enums.ProductType;
import ir.maktabsharif.repository.product.ProductRepository;
import ir.maktabsharif.service.product.exception.ProductSqlException;
import ir.maktabsharif.exceptions.NotExistException;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;


    @Override
    public boolean addProduct(String name, ProductType productType, double price) {
        Product product = new Product(name,productType,price);
        try {
            return repository.save(product) != null;
        }catch (ProductSqlException e){
            throw new ProductSqlException(e.getMessage());
        }

    }

    @Override
    public Product[] getProducts() {
        return repository.findAll();
    }

    @Override
    public Product findById(int productId)  {
        try {
            Product product = repository.findById(productId);
            if(product  == null) {
                throw new NotExistException("not exist product");
            }else {
                return product;
            }
        } catch (SQLException e) {
            throw new ProductSqlException("query is bad");
        }
    }
}
