package q01;

public class Account {
    private String accountNumber;
    private CreditCard creditCard;

    public Account(String accountNumber, CreditCard creditCard) {
        this.accountNumber = accountNumber;
        this.creditCard = creditCard;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "accountNumber='" + accountNumber + '\'' +
//                ", creditCard=" + creditCard +
//                '}';
//    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
