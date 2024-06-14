package ir.maktabsharif.menu.login;

import ir.maktabsharif.menu.util.Message;
import ir.maktabsharif.service.auth.AuthService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class LoginMenu {
    private final AuthService authService;
    private final Scanner scanner;
    private final Message message;

    public void show() {
        System.out.println("select between LOGIN = 1/ REGISTER = 2");
        String inputtedValue = scanner.nextLine();
        switch (inputtedValue) {
            case "1" -> {
                login();
            }
            case "2" -> {
                register();
            }
            default -> System.out.println(message.getInvalidInputMessage());
        }
        System.out.println();
    }

    private void register() {
        System.out.println(message.getInputMessage("username"));
        String username = scanner.nextLine();
        System.out.println(message.getInputMessage("password"));
        String password = scanner.nextLine();
        if (authService.checkExistUsername(username)) {
            System.out.println("This user has been registered! please enter another username.");
        } else {
            boolean register = authService.register(username, password);
            if (register) {
                System.out.println(STR."\{message.getSuccessfulMessage("registered ")} \{message.getEnterAgainMessage()}");
            } else {
                System.out.println(message.getFailedMessage("registering"));
            }

        }
    }

    private void login() {
        System.out.println(message.getInputMessage("username"));
        String username = scanner.nextLine();
        System.out.println(message.getInputMessage("password"));
        String password = scanner.nextLine();
        if (authService.login(username, password)) {
            System.out.println(message.getSuccessfulMessage("login"));
        }
    }
}

