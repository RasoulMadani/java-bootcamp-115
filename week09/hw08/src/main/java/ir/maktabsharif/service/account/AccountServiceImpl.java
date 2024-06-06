package ir.maktabsharif.service.account;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.enums.TransactionType;
import ir.maktabsharif.repository.account.AccountRepository;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findAccountByUserId(Long userId) {
        return accountRepository.findAccountByUserId(userId);
    }

    @Override
    public Account findAccountByCardNumber(String destinationCard) {
        return accountRepository.findAccountByCardNumber(destinationCard);
    }
    public boolean transferMoneyFromAccount(Account accountOrigin, Account accountDestination, double amount ,double feed){
        return accountRepository.transferMoneyFromAccount(accountOrigin,accountDestination,amount, feed);
    }

    @Override
    public Account findAccountByShabaNumber(String destinationShabaNumber) {
        return accountRepository.findAccountByShabaNumber(destinationShabaNumber);
    }

    @Override
    public boolean withdrawFromAccount(Account account, double amount) {
        return accountRepository.withdrawFromAccount(account,amount);
    }

    @Override
    public boolean depositToCard(Account account, double amount) {
        return accountRepository.depositToCard(account,amount);
    }

    @Override
    public boolean payaBatch(Account accountOrigin, Account[] accounts,  double amountDestination,double amountOrigin) {
        return accountRepository.payaBatch(accountOrigin,accounts, amountDestination, amountOrigin);
    }
}
