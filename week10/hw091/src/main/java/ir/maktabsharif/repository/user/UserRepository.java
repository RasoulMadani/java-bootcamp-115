package ir.maktabsharif.repository.user;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRepository;

public interface UserRepository extends BaseEntityRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    boolean checkExistUsername(String username);
    User save(User user);
}
