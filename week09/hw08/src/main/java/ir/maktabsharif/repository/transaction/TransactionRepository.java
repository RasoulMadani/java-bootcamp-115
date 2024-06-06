package ir.maktabsharif.repository.transaction;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.repository.BaseEntityRespository;

public interface TransactionRepository extends BaseEntityRespository {
    Transaction cardToCard(Account orginAccount ,Account destinationCard, double amount);

    boolean insertTransactionToDB(Transaction transaction);

    BaseEntity[] displayTransactionsByTransferType(String type, Long userId);

    BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1,String date2, Long userId);

    BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId);

    BaseEntity[] getAllTransactions(Long userId);


    boolean insertBatchTransactionToDB(Transaction[] transactions);
}
