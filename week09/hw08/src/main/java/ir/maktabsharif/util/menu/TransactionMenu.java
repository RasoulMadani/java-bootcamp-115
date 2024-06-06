package ir.maktabsharif.util.menu;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.enums.TransactionStatus;
import ir.maktabsharif.service.card.CardService;
import ir.maktabsharif.service.transaction.TransactionService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class TransactionMenu {
    public User token = null;

    public User getToken() {
        return token;
    }

    Scanner scanner;
    private final TransactionService transactionService;

    public TransactionMenu(TransactionService transactionService, Scanner scanner) {
        this.transactionService = transactionService;
        this.scanner = scanner;
    }

    public TransactionMenu setToken(User token) {
        this.token = token;
        return this;
    }

    public void show() {
        System.out.println(
                "select between" + "\n" +
                        "Card to Card  = 1" + "\n" +
                        "paya (individual) = 2" + "\n" +
                        "paya (batch) = 3" + "\n" +
                        "satna = 4" + "\n" +
                        "Card withdrawal = 5" + "\n" +
                        "Deposit to card = 6" + "\n" +
                        "Deposit to card = 6" + "\n" +
                        "go previous menu = 7"
        );

        int inputedValue = scanner.nextInt();
        switch (inputedValue) {
            case 1 -> {
                cardToCard();
            }
            case 2 -> {
                payaIndividual();
            }
            case 3 ->{
                payaBatch();
            }
            case 4 ->{
                satna();
            }
            case 5 ->{
                cardWithdrawal();
            }
            case 6 ->{
                depositToCard();
            }
            case 7 -> {
                return;
            }

            default -> System.out.println("roung input value");
        }
    }



    private void depositToCard() {
        System.out.println("Enter amount to transfer :");
        double amount = scanner.nextDouble();
        Transaction depositToCard = transactionService.depositToCard(amount, token.getId());
        if (depositToCard == null) {
            System.out.println("something went wrong !");
        }else {
            System.out.println(depositToCard.getMessage());
        }
    }

    private void cardWithdrawal() {
        System.out.println("Enter amount to transfer :");
        double amount = scanner.nextDouble();
        Transaction cardWithdrawal = transactionService.cardWithdrawal(amount, token.getId());
        if (cardWithdrawal == null) {
            System.out.println("something went wrong !");
        }else {
            System.out.println(cardWithdrawal.getMessage());
        }
    }

    private void satna() {
        System.out.println("Enter destination shaba number :");
        String destinationShabaNumber = scanner.next();
        System.out.println("Enter amount to transfer :");
        double amount = scanner.nextDouble();
        Transaction cardToCard = transactionService.satna(destinationShabaNumber, amount, token.getId());
        if (cardToCard == null) {
            System.out.println("something went wrong !");
        }else {
            System.out.println(cardToCard.getMessage());
        }
    }
    private void payaBatch() {
        System.out.println("Enter destination shaba numbers seperated with comma (,) :");
        String destinationShabaNumbers = scanner.next();
        System.out.println("Enter your amount :");
        double amount = scanner.nextDouble();
        String[] shabaNumbers = destinationShabaNumbers.split(",");
        System.out.println(Arrays.toString(shabaNumbers));

        Transaction[] payaBatch = transactionService.payaBatch(shabaNumbers, amount, token.getId());
        if (payaBatch.length == 0) {
            System.out.println("something went wrong !");
        }else {
            for (Transaction transaction : payaBatch){
                System.out.println(transaction);
            }
        }
    }

    private void payaIndividual() {
        System.out.println("Enter destination shaba number :");
        String destinationShabaNumber = scanner.next();
        System.out.println("Enter amount to transfer :");
        double amount = scanner.nextDouble();
        Transaction cardToCard = transactionService.payaIndividual(destinationShabaNumber, amount, token.getId());
        if (cardToCard == null) {
            System.out.println("something went wrong !");
        }else {
            System.out.println(cardToCard.getMessage());
        }
    }

    private void cardToCard() {
        System.out.println("Enter destination card :");
        String destinationCard = scanner.next();
        System.out.println("Enter amount to transfer :");
        double amount = scanner.nextDouble();
        Transaction cardToCard = transactionService.cardToCard(destinationCard, amount, token.getId());
        if (cardToCard == null) {
            System.out.println("something went wrong !");
        }else {
            System.out.println(cardToCard.getMessage());
        }
    }
}
