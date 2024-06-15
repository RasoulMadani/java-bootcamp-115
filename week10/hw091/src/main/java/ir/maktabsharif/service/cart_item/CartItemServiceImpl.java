package ir.maktabsharif.service.cart_item;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.CartItem;
import ir.maktabsharif.entity.Product;
import ir.maktabsharif.repository.cart_item.CartItemRepository;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository repository;

    @Override
    public boolean addItemToCart(CartItem cartItem) {
        return repository.save(cartItem) != null;
    }

    @Override
    public CartItem findProductInCart(Cart cart, Product product) {
        return repository.findSpecialProductInCart(cart, product);
    }

    @Override
    public boolean increaseProductCountInCart(CartItem cartItem) {
        return repository.increaseProductCountInCart(cartItem);
    }

    @Override
    public CartItem[] getCartItems(Cart cart) {
        return repository.getCartItems(cart);
    }

    @Override
    public boolean removeProductFromCart(int idCartItem) {
        try {
            CartItem cartItem = repository.findById((long) idCartItem);
            if (cartItem != null) {
                if (cartItem.getCount() > 1) {
                    return repository.decreaseProductCountInCart(cartItem);
                } else {
                    return repository.deleteById(cartItem.getId());
                }
            }
            // else for don't find product
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
