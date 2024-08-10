package ir.maktabsharif.service.cart;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.CartItem;
import ir.maktabsharif.entity.Product;

public interface CartService {
    Product[] getProducts();

    boolean addToCart(int productId);

    CartItem[] getCartItems();

    boolean removeProductFromCart(int idCartItem);

    double getTotalPriceCart();
}
