package ir.maktabsharif.util;

import ir.maktabsharif.menu.util.Input;
import ir.maktabsharif.menu.util.Message;
import ir.maktabsharif.repository.cart.CartRepository;
import ir.maktabsharif.repository.cart.CartRepositoryImpl;
import ir.maktabsharif.repository.cart_item.CartItemRepository;
import ir.maktabsharif.repository.cart_item.CartItemRepositoryImpl;
import ir.maktabsharif.repository.product.ProductRepository;
import ir.maktabsharif.repository.product.ProductRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.auth.AuthService;
import ir.maktabsharif.service.auth.AuthServiceImpl;
import ir.maktabsharif.service.cart.CartService;
import ir.maktabsharif.service.cart.CartServiceImpl;
import ir.maktabsharif.service.cart_item.CartItemService;
import ir.maktabsharif.service.cart_item.CartItemServiceImpl;
import ir.maktabsharif.service.product.ProductService;
import ir.maktabsharif.service.product.ProductServiceImpl;
import ir.maktabsharif.service.user.UserService;
import ir.maktabsharif.service.user.UserServiceImpl;
import ir.maktabsharif.menu.cart.CartMenu;
import ir.maktabsharif.menu.login.LoginMenu;
import ir.maktabsharif.menu.Menu;
import ir.maktabsharif.menu.product.ProductMenu;

import java.util.Scanner;

public class ApplicationContext {

    private static final ApplicationContext INSTANCE = new ApplicationContext();
    private static Menu menu;

    private ApplicationContext() {
        Scanner scanner = new Input().scanner;
        Message message = new Message();
        AuthHolder authHolder = new AuthHolder();
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        AuthService authService = new AuthServiceImpl(userService,authHolder);


        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);



        CartItemRepository cartItemRepository = new CartItemRepositoryImpl();
        CartItemService cartItemService = new CartItemServiceImpl(cartItemRepository);

        CartRepository cartRepository = new CartRepositoryImpl();
        CartService cartService = new CartServiceImpl(cartRepository,cartItemService,productService,userService,authHolder);

        LoginMenu loginMenu = new LoginMenu(authService, scanner,message);
        ProductMenu productMenu = new ProductMenu(scanner,productService,message);
        CartMenu cartMenu = new CartMenu(scanner,cartService,message);

        menu = new Menu(
                scanner,
                loginMenu,
                productMenu,
                cartMenu,
                authHolder
        );
    }

    public static ApplicationContext getInstance() {
        return INSTANCE;
    }

    public Menu getMenu() {
        return menu;
    }
}
