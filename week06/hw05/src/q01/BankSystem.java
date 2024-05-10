package q01;

import java.util.Scanner;

public class BankSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CreditCard creditCard = createCard();
        Account account = createAccount(creditCard);
        Branch branch = new Branch(2, "te", 1);
//        branch.addCustomer(cu)
        Customer customer = createCustomer(account);
        double credit = customer.getAccount().getCreditCard().getCredit();
        System.out.println("your credit is : " + credit);
    }

    public static CreditCard createCard() {
        System.out.println("Enter your credit :");
        int credit = scanner.nextInt();
        String cardNumber = new CreateNumberGenerator()
                .generate("6219", 16);

        System.out.println("your card number is : " + cardNumber);
        return new CreditCard(cardNumber, credit);
    }

    public static Account createAccount(CreditCard creditCard) {
        String accountNumber = new CreateNumberGenerator()
                .generate("1441", 16);
        System.out.println("Your account number is :" + accountNumber);
        return new Account(
                accountNumber,
                creditCard
        );
    }

    public static Customer createCustomer(Account account) {
        System.out.println("Enter Customer name :");
        String name = scanner.next();
        Customer customer  = new Customer(name, account);
        System.out.println("Your customer created : " + customer);
        return customer;
    }
}
