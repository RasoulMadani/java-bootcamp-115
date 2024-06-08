package ir.maktabsharif.service.user;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.user.UserRepository;

public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean register(User user) {
        BaseEntity user1 = repository.save(user);
        return user1 != null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return repository.checkExistUsername(username);
//        sendSms
    }
}
