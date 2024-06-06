package ir.maktabsharif.service.auth;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.user.UserRepository;

public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;

    public AuthServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean register(String username, String password) {
        User user = new User(username, password);
        BaseEntity user1 = repository.save(user);
        return user1 != null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return repository.checkExistUsername(username);
//        sendSms
    }

}
