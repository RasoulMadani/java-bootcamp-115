

public class Deposit extends Transaction {
    private static double wage;
    static {
        wage = Constant.getWageDeposit();
    }
    public Deposit(long id, Wallet wallet, double amount) {
        super(id, wallet, amount);
    }
    public static double getWageDeposit(){
        return wage;
    }
    public static void setWageDeposit(double w){
        wage = w;
    }
    public double getWage() {
        return wage;
    }

    @Override
    public void process() {
        getWallet().setCredit(getAmount() + getWallet().getCredit());
        setStatus(Status.ACCEPTED);
        getWallet().addTransaction(this);
    }
}
