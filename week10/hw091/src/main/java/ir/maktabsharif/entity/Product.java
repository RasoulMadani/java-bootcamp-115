package ir.maktabsharif.entity;

import ir.maktabsharif.enums.ProductType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class Product extends BaseEntity<Integer>{
    public static final String TABLE_NAME = "products";
    private String name;
    private ProductType type;
    private double price;

    public Product(Integer integer, String name, ProductType type, double price) {
        super(integer);
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Product(Integer integer) {
        super(integer);
    }
}
