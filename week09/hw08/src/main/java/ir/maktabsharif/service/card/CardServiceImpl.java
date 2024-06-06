package ir.maktabsharif.service.card;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Card;
import ir.maktabsharif.repository.bank.BankRepository;
import ir.maktabsharif.repository.card.CardRepository;

import java.sql.SQLException;

public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final BankRepository bankRepository;

    public CardServiceImpl(CardRepository cardRepository, BankRepository bankRepository) {
        this.cardRepository = cardRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public boolean addCard(String name, Long bank_id, Long user_id) {
        Card card = new Card(name, bank_id, user_id);
        return cardRepository.save(card) != null;
    }

    @Override
    public boolean checkExistCardName(String cardName) {
        return cardRepository.checkExistCardName(cardName);
    }

    public BaseEntity[] getBanks() {
        return bankRepository.findAll();
    }

    @Override
    public BaseEntity[] getCards(Long userId) {
        return cardRepository.getCards(userId);

    }
    public boolean deleteCard(Long cardId){
        try {
            return cardRepository.deleteById(cardId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public BaseEntity[] findCardByName(String name,Long userId){
        return cardRepository.findCardByName(name,userId);
    }

    @Override
    public BaseEntity[] findCardByBankName(String bankName, Long userId) {
        return cardRepository.findCardByBankName(bankName,userId);
    }
    public Card findCardByUserId(Long userId){
        return cardRepository.findCardByUserId(userId);
    }

}
