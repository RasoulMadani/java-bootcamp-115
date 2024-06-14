package ir.maktabsharif.service.product;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.Product;
import ir.maktabsharif.enums.ProductType;

import java.sql.SQLException;

public interface ProductService {
    boolean addProduct(String name , ProductType productType,double price);

    Product[] getProducts();

    Product findById(int productId) throws SQLException;
}
