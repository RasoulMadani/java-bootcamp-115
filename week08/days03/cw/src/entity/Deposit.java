package entity;

import entity.enumeration.Status;

public class Deposit extends Transaction{
    public Deposit(int id, Status status, int amount, Wallet wallet) {
        super(id, status, amount, wallet);
    }

    @Override
    public void process() {
        getWallet().setCredit(getWallet().getCredit()+ getAmount());
    }
}
