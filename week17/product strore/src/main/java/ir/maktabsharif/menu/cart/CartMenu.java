package ir.maktabsharif.menu.cart;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.CartItem;
import ir.maktabsharif.entity.Product;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.enums.ProductType;
import ir.maktabsharif.menu.util.Message;
import ir.maktabsharif.service.cart.CartService;
import ir.maktabsharif.service.cart_item.CartItemService;
import ir.maktabsharif.service.product.ProductService;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.InputMismatchException;
import java.util.Scanner;

@RequiredArgsConstructor
@Accessors(chain=true)
public class CartMenu {
    private @Getter @Setter User token = null;

    @NonNull Scanner scanner;
    private final CartService cartService;
    private final Message message;


    public void show() {
        while (true) {

            System.out.println(
                    "select between" + "\n" +
                            "Add To Cart = 1" + "\n" +
                            "Delete from Cart = 2" + "\n" +
                            "Show all cart items = 3" + "\n" +
                            "Get Total price of cart = 4" + "\n" +
                            "go previous menu = 5"
            );

            int inputtedValue = scanner.nextInt();
            switch (inputtedValue) {
                case 1 -> {
                    addToCart();
                }
                case 2 ->{
                    deleteProductFromCart();
                }
                case 3 ->{
                    showAllCartItems();
                }
                case 4 ->{
                    getTotalPriceCart();
                }
                case 5 -> {
                    return;
                }

                default -> System.out.println("wrong input value");
            }
            System.out.println();
        }
    }

    private void getTotalPriceCart() {
        double totalPrice = cartService.getTotalPriceCart();
        System.out.println(totalPrice);
    }

    private void showAllCartItems() {
        System.out.println("all products in your cart :");

        CartItem[] cartItems = cartService.getCartItems();
        for (CartItem cartItem : cartItems){
            System.out.println(cartItem);
        }
    }

    private void deleteProductFromCart() {
        System.out.println("select product id that you want to delete :");
        CartItem[] cartItems = cartService.getCartItems();
        for (CartItem cartItem : cartItems){
            System.out.println(cartItem);
        }
        int idCartItem = scanner.nextInt();
        boolean removed = cartService.removeProductFromCart(idCartItem);
        if(removed){
            System.out.println(message.getSuccessfulMessage("remove"));
        }
    }

    private void addToCart() {
        System.out.println("select product id that you want to add to cart :");
        Product[] products = cartService.getProducts();
        for(Product p : products){
            System.out.println(p);
        }
        int product_id = scanner.nextInt();
        boolean cart = cartService.addToCart(product_id);
        if(cart){
            System.out.println(message.getSuccessfulMessage("product added"));
        }
    }
}
