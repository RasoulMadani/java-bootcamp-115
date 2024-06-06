package ir.maktabsharif.service.transaction;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;

import java.sql.SQLException;

public interface TransactionService {
    Transaction cardToCard(String destinationCard, double amount, Long user_id) ;

    Transaction payaIndividual(String destinationShabaNumber, double amount, Long user_id);

    Transaction satna(String destinationShabaNumber, double amount, Long user_id);

    Transaction cardWithdrawal(double amount, Long userId);

    Transaction depositToCard(double amount, Long userId);

    BaseEntity[] displayTransactionsByTransferType(String type, Long userId);

    BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1,String date2, Long userId);

    BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId);

    BaseEntity[] getAllTransactions(Long userId);

    Transaction[] payaBatch(String[] shabaNumbers, double amount, Long id);
}
