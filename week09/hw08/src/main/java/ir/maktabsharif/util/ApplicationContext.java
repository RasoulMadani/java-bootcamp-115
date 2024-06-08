package ir.maktabsharif.util;

import ir.maktabsharif.repository.account.AccountRepository;
import ir.maktabsharif.repository.account.AccountRepositoryImpl;
import ir.maktabsharif.repository.bank.BankRepository;
import ir.maktabsharif.repository.bank.BankRepositoryImpl;
import ir.maktabsharif.repository.card.CardRepository;
import ir.maktabsharif.repository.card.CardRepositoryImpl;
import ir.maktabsharif.repository.transaction.TransactionRepository;
import ir.maktabsharif.repository.transaction.TransactionRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.repository.user.UserRespositoryImpl;
import ir.maktabsharif.service.account.AccountService;
import ir.maktabsharif.service.account.AccountServiceImpl;
import ir.maktabsharif.service.auth.AuthService;
import ir.maktabsharif.service.auth.AuthServiceImpl;
import ir.maktabsharif.service.bank.BankService;
import ir.maktabsharif.service.bank.BankServiceImpl;
import ir.maktabsharif.service.card.CardService;
import ir.maktabsharif.service.card.CardServiceImpl;
import ir.maktabsharif.service.report.ReportService;
import ir.maktabsharif.service.report.ReportServiceImpl;
import ir.maktabsharif.service.transaction.TransactionService;
import ir.maktabsharif.service.transaction.TransactionServiceImpl;
import ir.maktabsharif.service.user.UserService;
import ir.maktabsharif.service.user.UserServiceImpl;
import ir.maktabsharif.util.menu.Menu;

public class ApplicationContext {

    private static final ApplicationContext INSTANCE = new ApplicationContext();
    private static Menu menu;

    private ApplicationContext() {
    }

    public static ApplicationContext getInstance() {
        return INSTANCE;
    }

    static {
        UserRepository userRepository = new UserRespositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        AuthService authService = new AuthServiceImpl(userService);

        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);

        CardRepository cardRepository = new CardRepositoryImpl();
        BankRepository bankRepository = new BankRepositoryImpl();
        BankService bankService = new BankServiceImpl(bankRepository);
        CardService cardService = new CardServiceImpl(cardRepository, bankService,accountService);



        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        TransactionService transactionService = new TransactionServiceImpl(transactionRepository, cardService, accountService);
        ReportService reportService = new ReportServiceImpl(cardService,accountService,transactionService);
        menu = new Menu(
                authService,
                cardService,
                transactionService,
                reportService
        );
    }

    public Menu getMenu() {
        return menu;
    }
}
