package entity;

import entity.enumeration.Status;

public abstract class Transaction {
    private int id;
    private Status status;
    private int amount;
    private Wallet wallet;

    public Transaction(int id, Status status, int amount, Wallet wallet) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.wallet = wallet;

    }


    public int getId() {
        return id;
    }

    public Transaction setId(int id) {
        this.id = id;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Transaction setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Transaction setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Transaction setWallet(Wallet wallet) {
        this.wallet = wallet;
        return this;
    }
    public abstract void process();
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", wallet=" + wallet +
                '}';
    }
}
