package ir.maktabsharif.service.user;

import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.exceptions.NotExistException;
import ir.maktabsharif.exceptions.SqlError;

import java.sql.SQLException;

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
        User user1 = repository.save(user);
        return user1 != null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        return repository.checkExistUsername(username);
//        sendSms
    }

    @Override
    public User findUserById(Long userId) {
        try {
            User user = repository.findById(userId);
            if(user  == null) {
                throw new NotExistException("not exist user");
            }else {
                return user;
            }
        } catch (SQLException e) {
            throw new SqlError("sql not good !");
        }
    }
}
