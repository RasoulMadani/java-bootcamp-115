

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(123);
        Transaction transaction1 = new Deposit(1, wallet1, 1000);
        System.out.println(transaction1.getWage());
        Transaction transaction2 = new Withdraw(2, wallet1, 5000);
        System.out.println(transaction1.getWage());
        System.out.println(transaction2.getWage());

        Constant.setWageDeposit(1000);
        Constant.setWageWithdraw(1500);
        Transaction transaction3 = new Deposit(1, wallet1, 1000);
        System.out.println(transaction3.getWage());
        Transaction transaction4 = new Withdraw(2, wallet1, 5000);
        System.out.println(transaction3.getWage());
        System.out.println(transaction4.getWage());
       /* transaction1.process();
        System.out.println(wallet1.getCredit());

        System.out.println("------------------");
        Transaction transaction2 = new Withdraw(2, wallet1, 500);
        System.out.println(wallet1.getCredit());
        transaction2.process();
        System.out.println(wallet1.getCredit());
        System.out.println("------------------");
        System.out.println(Arrays.toString(wallet1.getTransactions()));
        System.out.println("----------------");
        System.out.println(wallet1.searchTransaction(2));
        System.out.println(wallet1.getCredit());*/
    }
}
