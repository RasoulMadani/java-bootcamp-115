package ir.maktabsharif.service.transaction;

import ir.maktabsharif.enums.TransactionType;

public class CalculatorFeed {
    // TODO singleton is better dan static
    public static double calculate(double amount, TransactionType type) {
        return switch (type) {
            case REQULAR -> calculateRegular(amount);
            case PAYA -> calculatePaya(amount);
            case SATNA -> calculateSatna(amount);
            default -> 0.0;
        };
    }

    public static double calculatePayaBatch(double amount,int countBatch) {
        if (countBatch <= 10) {
            return countBatch * 1200;
        } else {
            return ((countBatch - 10) * 120) + 12000;
        }
    }

    private static double calculateSatna(double amount) {
        double percentage = amount * 2 / 100;
        if (percentage > 25000) {
            return  25000;
        } else {
            return percentage;
        }
    }

    private static double calculatePaya(double amount) {
        double percentage = amount * 1 / 100;
        if (percentage < 240) {
            return 240;
        }
        if (percentage > 3000) {
            return 3000;
        }
        return 0;
    }

    private static double calculateRegular(double amount) {
        if (amount < 10000000) {
            return 500;
        } else {
            double amount1 = amount - 10000000;
            double countM = Math.floor(amount1 / 1000000);
            return countM * 100 + 500;
        }
    }
}
