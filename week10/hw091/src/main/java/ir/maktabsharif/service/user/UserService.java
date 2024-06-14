package ir.maktabsharif.service.user;

import ir.maktabsharif.entity.User;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);
    boolean checkExistUsername(String username);

    User findUserById(Long userId);
}
