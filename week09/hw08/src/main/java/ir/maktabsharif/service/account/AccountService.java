package ir.maktabsharif.service.account;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.enums.TransactionType;

import java.sql.SQLException;

public interface AccountService {
    Account findAccountByUserId(Long userId);

    Account findAccountByCardNumber(String destinationCard);
    boolean transferMoneyFromAccount(Account accountOrigin, Account accountDestination, double amount ,double feed);

    Account findAccountByShabaNumber(String destinationShabaNumber);

    boolean withdrawFromAccount(Account account, double amount);

    boolean depositToCard(Account account, double amount);

    boolean payaBatch(Account accountOrigin, Account[] accounts,  double amountDestination,double amountOrigin);
}
