package ir.maktabsharif.service.bank;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.repository.bank.BankRepository;

public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BaseEntity[] getBanks() {
        return bankRepository.findAll();
    }
}
