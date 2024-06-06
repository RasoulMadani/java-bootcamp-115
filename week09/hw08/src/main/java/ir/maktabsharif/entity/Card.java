package ir.maktabsharif.entity;

import java.util.Random;

public class Card extends BaseEntity{
    public static final String TABLE_NAME = "cards";
    private String name;
    private String card_number;
    private Long bank_id;
    private Long user_id;
    private Random random = new Random();

    public Card(String name, Long bank_id, Long user_id) {
        this.name = name;
        this.card_number = STR."6219\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}\{random.nextInt(9)}";
        this.bank_id = bank_id;
        this.user_id = user_id;
    }

    public Card(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Card(Long id, String name, String card_number, Long bank_id, Long user_id) {
        super(id);
        this.name = name;
        this.card_number = card_number;
        this.bank_id = bank_id;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public String getCard_number() {
        return card_number;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return STR."Card{id='\{getId()}\{'\''}, name='\{name}\{'\''}, card_number='\{card_number}\{'\''}, bank_id=\{bank_id}, user_id=\{user_id}\{'}'}";
    }
}
