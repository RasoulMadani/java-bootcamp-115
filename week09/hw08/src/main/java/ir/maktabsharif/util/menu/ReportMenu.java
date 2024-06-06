package ir.maktabsharif.util.menu;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.service.card.CardService;
import ir.maktabsharif.service.report.ReportService;

import java.util.Arrays;
import java.util.Scanner;

public class ReportMenu {
    public User token = null;

    public User getToken() {
        return token;
    }

    Scanner scanner;
    private final ReportService reportService;

    public ReportMenu(ReportService reportService, Scanner scanner) {
        this.reportService = reportService;
        this.scanner = scanner;
    }

    public void show() {

        while (true) {
            System.out.println(
                            "select between" + "\n" +
                            "Search card by name = 1" + "\n" +
                            "Search card on bank = 2" + "\n" +
                            "Show all cards = 3" + "\n" +
                            "Display transactions by transfer type = 4" + "\n" +
                            "Display transactions based on a specific day = 5" + "\n" +
                            "Display transactions based on a time period = 6" + "\n" +
                            "Display transactions based on the amount (larger than the entered amount) = 7" + "\n" +
                            "Display all transactions = 8" + "\n" +
                            "go previous menu = 9"
            );
            int inputtedValue = scanner.nextInt();

            switch (inputtedValue) {
                case 1 -> {
                    cardSearchByName();
                }
                case 2 -> {
                    cardSearchByBankName();
                }
                case 3 -> {
                    showAllCards();
                }
                case 4 -> {
                    displayTransactionsByTransferType();
                }
                case 5 -> {
                    displayTransactionsBasedOnSpecificDay();
                }
                case 6 -> {
                    transactionDisplayBasedOnTimePeriod();
                }
                case 7 -> {
                    displayTransactionsBasedOnAmount();
                }
                case 8 -> {
                    displayAllTransactions();
                }
                case 9 -> {
                    return;
                }

                default -> System.out.println("wrong input value");
            }
            System.out.println();
        }

    }

    private void displayAllTransactions() {
        BaseEntity[] baseEntities = reportService.getAllTransactions(token.getId());
        for (BaseEntity b : baseEntities) {
            System.out.println(b);
        }
    }

    private void displayTransactionsBasedOnAmount() {
        System.out.println("Enter your transaction amount :");
        double amount = scanner.nextDouble();
        BaseEntity[] baseEntities = reportService.displayTransactionsBasedOnAmount(amount, token.getId());
        for (BaseEntity b : baseEntities) {
            System.out.println(b);
        }
    }

    private void transactionDisplayBasedOnTimePeriod() {
        System.out.println("Enter your first transaction date : ex. 2024-12-10");
        String date1 = scanner.next();

        System.out.println("Enter your second transaction date : ex. 2024-12-10");
        String date2 = scanner.next();

        BaseEntity[] baseEntities = reportService.displayTransactionsBasedOnSpecificDay(date1, date2, token.getId());
        for (BaseEntity b : baseEntities) {
            System.out.println(b);
        }
    }

    private void displayTransactionsBasedOnSpecificDay() {
        System.out.println("Enter your transaction date : ex. 2024-12-10");
        String date = scanner.next();
        BaseEntity[] baseEntities = reportService.displayTransactionsBasedOnSpecificDay(date, date, token.getId());
        for (BaseEntity b : baseEntities) {
            System.out.println(b);
        }
    }

    private void displayTransactionsByTransferType() {
        System.out.println("Enter your transaction type :");
        String type = scanner.next();
        BaseEntity[] baseEntities = reportService.displayTransactionsByTransferType(type, token.getId());
        for (BaseEntity b : baseEntities) {
            System.out.println(b);
        }
    }

    public ReportMenu setToken(User token) {
        this.token = token;
        return this;
    }

    private void showAllCards() {
        System.out.println(Arrays.toString(reportService.getCards(token.getId())));
    }

    private void cardSearchByBankName() {
        System.out.println("Enter Bank name :");
        String name = scanner.next();
        BaseEntity[] cards = reportService.findCardByBankName(name, token.getId());
        System.out.println(Arrays.toString(cards));
    }

    private void cardSearchByName() {
        System.out.println("Enter Card name :");
        String name = scanner.next();
        BaseEntity[] cards = reportService.findCardByName(name, token.getId());
        System.out.println(Arrays.toString(cards));
    }


}
