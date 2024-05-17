package entity;

public class Wallet {
    private int id;
    private int credit;

    public Wallet(int id, int amount) {
        this.id = id;
        this.credit = amount;
    }

    public int getId() {
        return id;
    }

    public Wallet setId(int id) {
        this.id = id;
        return this;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", credit=" + credit +
                '}';
    }
}
