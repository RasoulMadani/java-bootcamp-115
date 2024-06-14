package ir.maktabsharif.service.auth;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.service.user.UserService;
import ir.maktabsharif.util.AuthHolder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthHolder authHolder;


    @Override
    public boolean login(String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            authHolder.setTokenId( user.getId());
            authHolder.setTokenName(user.getUsername());
            return true;
        }
        return false;
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
