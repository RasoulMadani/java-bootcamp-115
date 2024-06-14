package ir.maktabsharif.repository.cart_item;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.CartItem;
import ir.maktabsharif.entity.Product;
import ir.maktabsharif.repository.BaseEntityRepository;

public interface CartItemRepository extends BaseEntityRepository<CartItem,Long> {
    CartItem save(CartItem cartItem);

    CartItem findSpecialProductInCart(Cart cart, Product product);

    boolean increaseProductCountInCart(CartItem cartItem);

    CartItem[] getCartItems(Cart cart);

    boolean decreaseProductCountInCart(CartItem cartItem);
}
