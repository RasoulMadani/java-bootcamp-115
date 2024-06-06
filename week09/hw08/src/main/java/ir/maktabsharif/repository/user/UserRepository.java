package ir.maktabsharif.repository.user;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRespository;

public interface UserRepository extends BaseEntityRespository {
    User findByUsernameAndPassword(String username, String password);
    boolean checkExistUsername(String username);
}
