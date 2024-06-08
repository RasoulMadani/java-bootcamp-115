package ir.maktabsharif.service.report;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.service.account.AccountService;
import ir.maktabsharif.service.card.CardService;
import ir.maktabsharif.service.transaction.TransactionService;

public class ReportServiceImpl implements ReportService{
    CardService cardService;
    AccountService accountService;
    TransactionService transactionService;

    public ReportServiceImpl(CardService cardService, AccountService accountService, TransactionService transactionService) {
        this.cardService = cardService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Override
    public BaseEntity[] findCardByName(String name, Long userId) {
       return cardService.findCardByName(name,userId);
    }

    @Override
    public BaseEntity[] getCards(Long userId) {
        return cardService.getCards(userId);
    }

    @Override
    public BaseEntity[] findCardByBankName(String name, Long userId) {
        return cardService.findCardByBankName(name,userId);
    }

    @Override
    public BaseEntity[] displayTransactionsByTransferType(String type, Long userId) {
        return transactionService.displayTransactionsByTransferType(type,userId);
    }

    @Override
    public BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1,String date2, Long userId) {
        return transactionService.displayTransactionsBasedOnSpecificDay(date1,date2,userId);
    }
    // TODO epoch millis
    @Override
    public BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId) {
        return transactionService.displayTransactionsBasedOnAmount(amount,userId);
    }

    @Override
    public BaseEntity[] getAllTransactions(Long userId) {
        return transactionService.getAllTransactions(userId);
    }
}
