package ir.maktabsharif.service.cart;

import ir.maktabsharif.entity.*;
import ir.maktabsharif.enums.DiscountType;
import ir.maktabsharif.repository.cart.CartRepository;
import ir.maktabsharif.service.cart_item.CartItemService;
import ir.maktabsharif.service.product.ProductService;
import ir.maktabsharif.service.user.UserService;
import ir.maktabsharif.exceptions.NotExistException;
import ir.maktabsharif.util.AuthHolder;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final UserService userService;
    private final AuthHolder authHolder;
    @Override
    public Product[] getProducts() {
        return productService.getProducts();
    }

    @Override
    public boolean addToCart(int productId) {

        try {
            Product product = productService.findById(productId);
            User user = userService.findUserById(authHolder.getTokenId());
            Cart cart = cartRepository.findByIdAndUnPaid(authHolder.getTokenId());
            if (cart == null) {
                cart = new Cart(user);
                cart = cartRepository.save(cart);
                if (cart != null) {
                    CartItem cartItem = new CartItem(product, 1, cart, new Discount(1L));
                   return cartItemService.addItemToCart(cartItem);
                }
            } else {
                CartItem cartItem = cartItemService.findProductInCart(cart, product);
                if (cartItem != null) {
                    return cartItemService.increaseProductCountInCart(cartItem);
                }else {
                    cartItem = new CartItem(product, 1, cart, new Discount(1L));
                   return cartItemService.addItemToCart(cartItem);
                }
            }
        } catch (NotExistException e) {
            System.out.println("user or product not exist");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }

    @Override
    public CartItem[] getCartItems() {
        Cart cart = cartRepository.findByIdAndUnPaid(authHolder.getTokenId());
        return cartItemService.getCartItems(cart);
    }

    @Override
    public boolean removeProductFromCart(int idCartItem) {
        return cartItemService.removeProductFromCart(idCartItem);
    }

    @Override
    public double getTotalPriceCart() {
        Cart cart = cartRepository.findByIdAndUnPaid(authHolder.getTokenId());
        CartItem[] cartItems = cartItemService.getCartItems(cart);
        double price ;
        double discountAmount;
        DiscountType discountType;
        double productDiscount;
        double productPrice=0;
        double totalPrice=0;
        for (CartItem cartItem : cartItems){
          price = cartItem.getProduct().getPrice();
          discountAmount = cartItem.getDiscount().getAmount();
          discountType = cartItem.getDiscount().getType();
          // TODO change one line of if
          if(discountType == DiscountType.PERCENTAGE){
              productDiscount = (price * discountAmount /100) * cartItem.getCount();
              productPrice = price * cartItem.getCount() - productDiscount;
          }else if(discountType == DiscountType.PRICE) {
              productPrice = price * cartItem.getCount() - discountAmount * cartItem.getCount();
          }
          totalPrice+=productPrice;
        }
        return totalPrice;
    }
}
