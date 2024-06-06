package ir.maktabsharif.service.card;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Card;

public interface CardService {
    boolean addCard(String name,Long bank_id,Long user_id);
    boolean checkExistCardName(String cardName);
    BaseEntity[] getBanks();

    BaseEntity[] getCards(Long userId);
    boolean deleteCard(Long cardId);
    BaseEntity[] findCardByName(String name,Long userId);

    BaseEntity[] findCardByBankName(String bankName, Long userId);
    Card findCardByUserId(Long userId);

}
