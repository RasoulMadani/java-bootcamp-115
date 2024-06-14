package ir.maktabsharif.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CartItem extends BaseEntity<Long>{
    public static final String TABLE_NAME = "cart_items";
    Product product;
    int count;
    Cart cart;
    Discount discount;

    public CartItem(Product product, int count, Cart cart,Discount discount) {
        this.product = product;
        this.count = count;
        this.cart = cart;
        this.discount = discount;
    }

    public CartItem(Long aLong, Product product, int count, Cart cart, Discount discount) {
        super(aLong);
        this.product = product;
        this.count = count;
        this.cart = cart;
        this.discount = discount;
    }
}
