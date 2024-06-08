package ir.maktabsharif.service.transaction;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.enums.TransactionStatus;
import ir.maktabsharif.enums.TransactionType;
import ir.maktabsharif.repository.transaction.TransactionRepository;
import ir.maktabsharif.service.account.AccountService;
import ir.maktabsharif.service.card.CardService;

public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;
    CardService cardService;
    AccountService accountService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, CardService cardService, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.cardService = cardService;
        this.accountService = accountService;
    }

    @Override
    public Transaction cardToCard(Long user_id, String destinationCard, double amount) {

        Account accountOrigin = accountService.findAccountByUserId(user_id);
        Account accountDestination = accountService.findAccountByCardNumber(destinationCard);
        //  TODO add message fo not found account;

        if (amount > 15000000) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.REQULAR, "amount out of bound");
        }

        double feed = CalculatorFeed.calculate(amount, TransactionType.REQULAR);


        if (accountOrigin.getBalance() < amount + feed) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.REQULAR, "balance not exist");
        }


        boolean bole = accountService.transferMoneyFromAccount(accountOrigin, accountDestination, amount, feed);
        if (bole) {
            Transaction transaction = new Transaction(accountOrigin, accountDestination, amount, feed, TransactionStatus.DONE, TransactionType.REQULAR, "transfer done!");
            boolean inserted = transactionRepository.insertTransactionToDB(transaction);
            if (inserted) {
                return transaction;
            }
        }
        return null;
    }

    private Transaction getFaildTransaction(Account accountOrigin, Account accountDestination, double amount, TransactionType reqular, String balance_not_exist) {
        Transaction transaction = new Transaction(accountOrigin, accountDestination, amount, 0, TransactionStatus.FAILED, reqular, balance_not_exist);
        boolean inserted = transactionRepository.insertTransactionToDB(transaction);
        if (inserted) {
            return transaction;
        }
        return null;
    }

    @Override
    public Transaction payaIndividual(String destinationShabaNumber, double amount, Long user_id) {
        Account accountOrigin = accountService.findAccountByUserId(user_id);
        Account accountDestination = accountService.findAccountByShabaNumber(destinationShabaNumber);

        if (15000000 > amount || amount > 50000000) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.PAYA, "amount out of bound");
        }

        double feed = CalculatorFeed.calculate(amount, TransactionType.PAYA);


        if (accountOrigin.getBalance() < amount + feed) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.PAYA, "balance not exist");
        }


        boolean bole = accountService.transferMoneyFromAccount(accountOrigin, accountDestination, amount, feed);
        if (bole) {
            Transaction transaction = new Transaction(accountOrigin, accountDestination, amount, feed, TransactionStatus.DONE, TransactionType.PAYA, "transfer done!");
            boolean inserted = transactionRepository.insertTransactionToDB(transaction);
            if (inserted) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public Transaction satna(String destinationShabaNumber, double amount, Long user_id) {
        Account accountOrigin = accountService.findAccountByUserId(user_id);
        Account accountDestination = accountService.findAccountByShabaNumber(destinationShabaNumber);

        if (50000000 > amount || amount > 200000000) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.SATNA, "amount out of bound");
        }

        double feed = CalculatorFeed.calculate(amount, TransactionType.PAYA);


        if (accountOrigin.getBalance() < amount + feed) {
            return getFaildTransaction(accountOrigin, accountDestination, amount, TransactionType.SATNA, "balance not exist");
        }


        boolean bole = accountService.transferMoneyFromAccount(accountOrigin, accountDestination, amount, feed);
        if (bole) {
            Transaction transaction = new Transaction(accountOrigin, accountDestination, amount, feed, TransactionStatus.DONE, TransactionType.SATNA, "transfer done!");
            boolean inserted = transactionRepository.insertTransactionToDB(transaction);
            if (inserted) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public Transaction cardWithdrawal(double amount, Long userId) {
        Account account = accountService.findAccountByUserId(userId);
        boolean bole = accountService.withdrawFromAccount(account, amount);
        if (bole) {
            Transaction transaction = new Transaction(account, account, amount, 0, TransactionStatus.DONE, TransactionType.CARD_WITHDRAW, "transfer done!");
            boolean inserted = transactionRepository.insertTransactionToDB(transaction);
            if (inserted) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public Transaction depositToCard(double amount, Long userId) {
        Account account = accountService.findAccountByUserId(userId);
        boolean bole = accountService.depositToCard(account, amount);
        if (bole) {
            Transaction transaction = new Transaction(account, account, amount, 0, TransactionStatus.DONE, TransactionType.DEPOSIT_TO_CARD, "transfer done!");
            boolean inserted = transactionRepository.insertTransactionToDB(transaction);
            if (inserted) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public BaseEntity[] displayTransactionsByTransferType(String type, Long userId) {
        return transactionRepository.displayTransactionsByTransferType(type, userId);
    }

    @Override
    public BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1, String date2, Long userId) {
        return transactionRepository.displayTransactionsBasedOnSpecificDay(date1, date2, userId);
    }

    @Override
    public BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId) {
        return transactionRepository.displayTransactionsBasedOnAmount(amount, userId);
    }

    @Override
    public BaseEntity[] getAllTransactions(Long userId) {
        return transactionRepository.getAllTransactions(userId);
    }

    @Override
    public Transaction[] payaBatch(String[] shabaNumbers, double amountDestination, Long userId) {
        Account accountOrigin = accountService.findAccountByUserId(userId);

        Account[] accounts = new Account[shabaNumbers.length];
        int index = 0;
        for (String s : shabaNumbers) {
            accounts[index++] = accountService.findAccountByShabaNumber(s);
        }
        double feed = CalculatorFeed.calculatePayaBatch(amountDestination, shabaNumbers.length);

        double amountOrigin = feed + shabaNumbers.length * amountDestination;
        double feedPerAccount = feed/accounts.length;
        boolean bole = accountService.payaBatch(accountOrigin, accounts, amountDestination, amountOrigin);
        Transaction[] transactions = new Transaction[accounts.length];
        int index1 = 0;
        if (bole) {
            for (Account account :accounts) {
                transactions[index1++] = new Transaction(accountOrigin, account, amountDestination, feedPerAccount, TransactionStatus.DONE, TransactionType.PAYA_BATCH, "transfer done!");
            }
            boolean inserted = transactionRepository.insertBatchTransactionToDB(transactions);
            if (inserted) {
                return transactions;
            }
        }
        return null;
    }
}
