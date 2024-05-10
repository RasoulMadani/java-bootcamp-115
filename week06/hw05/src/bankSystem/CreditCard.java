package bankSystem;

public class CreditCard {

    private String cartNumber;
    private double credit;

    public CreditCard(String cartNumber, double credit) {
        this.cartNumber = cartNumber;
        this.credit = credit;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cartNumber='" + cartNumber + '\'' +
                ", credit=" + credit +
                '}';
    }
}
