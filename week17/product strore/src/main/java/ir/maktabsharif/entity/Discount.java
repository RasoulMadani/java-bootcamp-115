package ir.maktabsharif.entity;

import ir.maktabsharif.enums.DiscountType;
import lombok.Getter;

@Getter
public class Discount extends BaseEntity<Long> {
    private String name;
    private String code;
    private double amount;
    private DiscountType type;

    public Discount(Long aLong, String name, String code, double amount, DiscountType type) {
        super(aLong);
        this.name = name;
        this.code = code;
        this.amount = amount;
        this.type = type;
    }

    public Discount(Long aLong) {
        super(aLong);
    }
}
