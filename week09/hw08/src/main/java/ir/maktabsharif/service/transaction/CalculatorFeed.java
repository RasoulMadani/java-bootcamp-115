package ir.maktabsharif.service.transaction;

import ir.maktabsharif.enums.TransactionType;

public class CalculatorFeed {
    double amount;
    TransactionType type;
    double feed = 0;
    int countBatch;

    public CalculatorFeed(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public CalculatorFeed(double amount, TransactionType type, int countBatch) {
        this.amount = amount;
        this.type = type;
        this.countBatch = countBatch;
    }

    public double calculate() {
        switch (type) {
            case REQULAR -> {
                calculateRegular();
            }
            case PAYA -> {
                calculatePaya();
            }
            case SATNA -> {
                calculateSatna();
            }
            case PAYA_BATCH -> {
                calculatePayaBatch();
            }
        }
        return feed;
    }

    private void calculatePayaBatch() {
        if (countBatch <= 10) {
            feed = countBatch * 1200;
        } else {
             feed = ((countBatch - 10) * 120) + 12000;
        }
    }

    private void calculateSatna() {
        double percentage = amount * 2 / 100;
        if (percentage > 25000) {
            feed = 25000;
        } else {
            feed = percentage;
        }
    }

    private void calculatePaya() {
        double percentage = amount * 1 / 100;
        if (percentage < 240) {
            feed = 240;
        }
        if (percentage > 3000) {
            feed = 3000;
        }
    }

    private void calculateRegular() {
        if (amount < 10000000) {
            feed = 500;
        } else {
            double amount1 = amount - 10000000;
            double countM = Math.floor(amount1 / 1000000);
            feed = countM * 100 + 500;
        }
    }
}
