

public class Withdraw extends Transaction {
    public static double wage ;

    static {
        wage = Constant.getWageWithdraw();
    }

    public Withdraw(long id, Wallet wallet, double amount) {
        super(id, wallet, amount);
    }

    public double getWage() {
        return wage;
    }

    @Override
    public void process() {
        if (getWallet().getCredit() >= getAmount()) {
            getWallet().setCredit(getWallet().getCredit() - getAmount());
            setStatus(Status.ACCEPTED);
            getWallet().addTransaction(this);
        } else {
            System.out.println("not enough credit!");
            setStatus(Status.CANCELLED);
        }

    }
}
