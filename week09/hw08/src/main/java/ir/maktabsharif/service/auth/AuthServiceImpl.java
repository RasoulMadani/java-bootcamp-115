package ir.maktabsharif.service.auth;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.service.user.UserService;

public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User login(String username, String password) {
        return userService.login(username, password);
    }

    @Override
    public boolean register(String username, String password) {
        User user = new User(username, password);
        return userService.register(user);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userService.checkExistUsername(username);
//        sendSms
    }

}
