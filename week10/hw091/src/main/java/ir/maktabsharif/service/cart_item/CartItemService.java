package ir.maktabsharif.service.cart_item;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.CartItem;
import ir.maktabsharif.entity.Product;

public interface CartItemService {
    boolean addItemToCart(CartItem cartItem);

    CartItem findProductInCart(Cart cart, Product product);

    boolean increaseProductCountInCart(CartItem cartItem);

    CartItem[] getCartItems(Cart cart);

    boolean removeProductFromCart(int idCartItem);
}
