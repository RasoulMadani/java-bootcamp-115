package ir.maktabsharif.repository.product;

import ir.maktabsharif.entity.Product;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRepository;

public interface ProductRepository extends BaseEntityRepository<Product,Integer> {
    Product save(Product product);
}
