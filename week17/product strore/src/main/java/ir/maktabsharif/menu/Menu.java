package ir.maktabsharif.menu;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.menu.cart.CartMenu;
import ir.maktabsharif.menu.login.LoginMenu;
import ir.maktabsharif.menu.product.ProductMenu;
import ir.maktabsharif.util.AuthHolder;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class Menu {
    private final Scanner scanner;
    private final LoginMenu loginMenu;
    private final ProductMenu productMenu;
    private final CartMenu cartMenu;
    private final AuthHolder authHolder;

    public void show() {
        while (authHolder.getTokenId() == null) {
           loginMenu.show();
        }
        commandManager();
    }

    public void commandManager() {
        while (true) {
            System.out.println("select between PRODUCT = 1/ Cart = 2/ REPORT = 3");
            int inputtedValue = scanner.nextInt();
            switch (inputtedValue) {
                case 1 -> {
                    productMenu.show();
                }
                case 2 -> {
                    cartMenu.show();
                }
            }
        }

    }

}
