package ir.maktabsharif.util.menu;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.service.auth.AuthService;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginMenu {
    public User token = null;

    public User getToken() {
        return token;
    }

    public void setToken(User token) {
        this.token = token;
    }

    Scanner scanner;
    private final AuthService authService;

    public LoginMenu(AuthService authService, Scanner scanner) {
        this.authService = authService;
        this.scanner = scanner;
    }

    public User show() {
        System.out.println("select between LOGIN = 1/ REGISTER = 2");
        String inputedValue = scanner.nextLine();
        switch (inputedValue) {
            case "1" -> {
                login();
            }
            case "2" -> {
                register();
            }
            default -> System.out.println("wrong input value");
        }
        System.out.println();

        return token;
    }

    private User register() {
        System.out.println("enter your username");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        if (authService.checkExistUsername(username)) {
            System.out.println("This user has been registered! please enter another username.");
        } else {
            boolean register = authService.register(username, password);
            if(register){
                System.out.println("you are registered . please logged in.");
            }else {
                System.out.println("you dont logged in .try again .");
            }
            return token;
        }
        return token;
    }

    private User login() {
        System.out.println("enter your username");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        token = authService.login(username, password);
        if (token != null){
            System.out.println("you are logged in successfully...");
        }
        return token;
    }
}

