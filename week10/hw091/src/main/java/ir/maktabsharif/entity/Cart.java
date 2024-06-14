package ir.maktabsharif.entity;

import ir.maktabsharif.enums.CartStatus;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.Date;
@RequiredArgsConstructor
@Getter
@ToString(callSuper = true)
public class Cart extends BaseEntity<Long>{
    public static final String TABLE_NAME = "carts";
    double totalPrice;
    private  User user;
    int totalCount;
    CartStatus cartStatus = CartStatus.UNPAID;
    long epochMilliseconds = Instant.now().toEpochMilli();
    CartItem[] cartItems;
//    Instant instant = Instant.ofEpochMilli(milliseconds);

    public Cart(Long aLong, double totalPrice, User user, int totalCount, CartStatus cartStatus, long epochMilliseconds) {
        super(aLong);
        this.totalPrice = totalPrice;
        this.user = user;
        this.totalCount = totalCount;
        this.cartStatus = cartStatus;
        this.epochMilliseconds = epochMilliseconds;
    }

    public Cart(User user) {
        this.user = user;
    }

    public Cart(Long aLong) {
        super(aLong);
    }
}
