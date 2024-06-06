package ir.maktabsharif.util.menu;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.service.auth.AuthService;
import ir.maktabsharif.service.card.CardService;
import ir.maktabsharif.service.report.ReportService;
import ir.maktabsharif.service.transaction.TransactionService;

import java.util.Scanner;


public class Menu {
    private User token;
    Scanner scanner = new Scanner(System.in);
    CardMenu cardMenu;
    LoginMenu loginMenu;
    TransactionMenu transactionMenu;
    ReportMenu reportMenu;

    public Menu(
            AuthService authService,
            CardService cardService,
            TransactionService transactionService,
            ReportService reportService
    ) {
        cardMenu = new CardMenu(cardService, token, scanner);
        loginMenu = new LoginMenu(authService, scanner);
        transactionMenu = new TransactionMenu(transactionService, scanner);
        reportMenu = new ReportMenu(reportService, scanner);

    }

    public void show() {
        while (token == null) {
            token = loginMenu.show();
        }
        commandManager();

    }

    public void commandManager() {
        while (true) {
            System.out.println("select between CARD = 1/ TRANSACTION = 2/ REPORT = 3");
            int inputedValue = scanner.nextInt();
            switch (inputedValue) {
                case 1 -> {
                    cardMenu.setToken(token).show();
                }
                case 2 -> {
                    transactionMenu.setToken(token).show();
                }
                case 3 -> {
                    reportMenu.setToken(token).show();
                }
            }
        }

    }

}
