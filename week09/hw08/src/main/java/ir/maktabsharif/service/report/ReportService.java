package ir.maktabsharif.service.report;

import com.sun.jdi.request.StepRequest;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;

public interface ReportService {
    BaseEntity[] findCardByName(String name, Long userId);

    BaseEntity[] getCards(Long userId);

    BaseEntity[] findCardByBankName(String name, Long userId);

    BaseEntity[] displayTransactionsByTransferType(String type ,Long userId);

    BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1, String date2, Long userId);

    BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId);

    BaseEntity[] getAllTransactions(Long userId);
}
