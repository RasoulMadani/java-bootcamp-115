package ir.maktabsharif.util.menu;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.service.auth.AuthService;
import ir.maktabsharif.service.card.CardService;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CardMenu {
    public User token = null;

    public User getToken() {
        return token;
    }


    Scanner scanner;
    private final CardService cardService;

    public CardMenu(CardService authService, User token, Scanner scanner) {
        this.cardService = authService;
        this.scanner = scanner;
        this.token = token;
    }

    public CardMenu setToken(User token) {
        this.token = token;
        return this;
    }

    public void show() {
        while (true) {

            System.out.println(
                    "select between" + "\n" +
                            "Add Card = 1" + "\n" +
                            "Remover Card = 2" + "\n" +
                            "Search card by name = 3" + "\n" +
                            "Search card on bank = 4" + "\n" +
                            "Show all cards = 5" + "\n" +
                            "go previous menu = 6"
            );

            int inputedValue = scanner.nextInt();
            switch (inputedValue) {
                case 1 -> {
                    addCard();
                }
                case 2 -> {
                    removeCard();
                }
                case 3 -> {
                    cardSearchByName();
                }
                case 4 -> {
                    cardSearchByBankName();
                }
                case 5 -> {
                    showAllCards();
                }
                case 6 -> {
                    return;
                }

                default -> System.out.println("roung input value");
            }
            System.out.println();
        }
    }

    private void showAllCards() {
        System.out.println(Arrays.toString(cardService.getCards(token.getId())));
    }

    private void cardSearchByBankName() {
        System.out.println("Enter Bank name :");
        String name = scanner.next();
        BaseEntity[] cards = cardService.findCardByBankName(name, token.getId());
        System.out.println(Arrays.toString(cards));
    }

    private void cardSearchByName() {
        System.out.println("Enter Card name :");
        String name = scanner.next();
        BaseEntity[] cards = cardService.findCardByName(name, token.getId());
        System.out.println(Arrays.toString(cards));
    }

    private void removeCard() {
        System.out.println("select your card id from the list below :");
        System.out.println(Arrays.toString(cardService.getCards(token.getId())));
        Long cardId = scanner.nextLong();
        boolean deleteCard = cardService.deleteCard(cardId);
        if (deleteCard) {
            System.out.println("you are deleted card successfully.");
        } else {
            System.out.println("Something went wrong");
        }
    }

    private void addCard() {
        boolean flagName = true;
        String name = null;
        while (flagName) {
            System.out.println("enter card name :");
            name = scanner.next();
            if (cardService.checkExistCardName(name)) {
                System.out.println("This card name has been exist! please enter another name.");
            } else {
                flagName = false;
            }
        }
        System.out.println("select your bank id from the list below :");
        System.out.println(Arrays.toString(cardService.getBanks()));
        Long bankId = scanner.nextLong();

        boolean register = cardService.addCard(name, bankId, token.getId());
        if (register) {
            System.out.println("you are registered card successfully.");
        } else {
            System.out.println("Something went wrong");
        }
    }
}
