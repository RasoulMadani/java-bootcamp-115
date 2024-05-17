

import java.util.Arrays;

public class Wallet {
   // private int index;
    private long id;
    private double credit;
    private Transaction[] transactions;

    public Wallet(long id) {
        this.id = id;
        this.transactions = new Transaction[0];
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        Transaction[] newTransaction = new Transaction[transactions.length+1];
        int i;
        for ( i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                newTransaction[i] = transactions[i];
            }
        }
        newTransaction[i]=transaction;
        transactions=newTransaction;
    }

    public Transaction searchTransaction(long id){
        for (Transaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Wallet: id=" + id+Arrays.toString(transactions) ;
    }
}
