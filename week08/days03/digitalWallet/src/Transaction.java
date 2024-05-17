

public abstract class Transaction {
    private long id;
    private Wallet wallet;
    private double amount;
    private Status status;

    public Transaction(long id, Wallet wallet, double amount) {
        this.id = id;
        this.wallet = wallet;
        this.amount = amount;
        this.status = Status.PENDING;
    }

    public abstract double getWage();

    public abstract void process();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
