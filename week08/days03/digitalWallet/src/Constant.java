

public class Constant {
    private static double wageDeposit = 500;
    private static double wageWithdraw = 600;

    public static double getWageDeposit() {
        return wageDeposit;
    }

    public static void setWageDeposit(double wageDeposit) {
        Constant.wageDeposit = wageDeposit;
        Deposit.setWageDeposit(Constant.wageDeposit);
    }

    public static double getWageWithdraw() {
        return wageWithdraw;
    }

    public static void setWageWithdraw(double wageWithdraw) {
        Constant.wageWithdraw = wageWithdraw;
        Withdraw.wage = Constant.wageWithdraw;
    }
}
