package entity;

import entity.enumeration.Status;

public class Withdraw  extends Transaction{

    public Withdraw(int id, Status status, int amount, Wallet wallet) {
        super(id, status, amount, wallet);
    }

    @Override
    public void process() {
        if(getWallet().getCredit() >= getAmount()){
            getWallet().setCredit(getWallet().getCredit() - getAmount());
        }
    }
}
