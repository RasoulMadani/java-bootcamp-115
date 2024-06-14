package ir.maktabsharif.repository.cart;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.Product;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRepository;

public interface CartRepository extends BaseEntityRepository<Cart,Long> {
    Cart findByIdAndUnPaid(Long userId);
    Cart save(Cart cart);
}
