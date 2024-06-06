package ir.maktabsharif.entity;

public class Account extends  BaseEntity{
    public static final String TABLE_NAME = "accounts";
    long user_id;
    long bank_id;
    Double balance;
    String shabaNumber;
    String accountNumber;

    public Account(Long id, long user_id, long bank_id, Double balance, String shabaNumber, String accountNumber) {
        super(id);
        this.user_id = user_id;
        this.bank_id = bank_id;
        this.balance = balance;
        this.shabaNumber = shabaNumber;
        this.accountNumber = accountNumber;
    }

    public Account(Long id) {
        super(id);
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                " id=" + getId() +
                ", user_id=" + user_id +
                ", bank_id=" + bank_id +
                ", balance=" + balance +
                ", shabaNumber='" + shabaNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
