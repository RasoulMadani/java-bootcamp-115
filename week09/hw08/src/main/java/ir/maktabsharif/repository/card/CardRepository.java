package ir.maktabsharif.repository.card;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Card;
import ir.maktabsharif.repository.BaseEntityRespository;

public interface CardRepository extends BaseEntityRespository {
    boolean checkExistCardName(String cardName);

    BaseEntity[] getCards(Long userId);

    BaseEntity[] findCardByName(String name,Long userId);

    BaseEntity[] findCardByBankName(String bankName, Long userId);

    Card findCardByUserId(Long userId);
}
