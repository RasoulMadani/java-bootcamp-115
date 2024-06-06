package ir.maktabsharif.entity;

import ir.maktabsharif.enums.TransactionStatus;
import ir.maktabsharif.enums.TransactionType;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction extends BaseEntity{
    public static final String TABLE_NAME = "transactions";
    Timestamp date;
    Account originAccount;
    Account destinationAccount;

    double amount;
    TransactionType type;
    double fee;
    TransactionStatus status;
    String message;

    public Transaction(Account originAccount,Account destinationAccount,  double amount,  double fee, TransactionStatus status,TransactionType type,String message) {
        this.destinationAccount = destinationAccount;
        this.originAccount = originAccount;
        this.amount = amount;
        this.type = type;
        this.fee = fee;
        this.status = status;
        this.message = message;
    }
    public Transaction(Account originAccount,Account destinationAccount,  double amount,  double fee, TransactionStatus status,TransactionType type,String message ,Timestamp date) {
        this.destinationAccount = destinationAccount;
        this.originAccount = originAccount;
        this.amount = amount;
        this.type = type;
        this.fee = fee;
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public Transaction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Account getOriginAccount() {
        return originAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public Timestamp getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getFee() {
        return fee;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", originAccount=" + originAccount +
                ", destinationAccount=" + destinationAccount +
                ", amount=" + amount +
                ", type=" + type +
                ", fee=" + fee +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
