package ir.maktabsharif.service.auth;

import ir.maktabsharif.entity.User;

public interface AuthService {
    User login(String username, String password);
    boolean register(String username, String password);
    boolean checkExistUsername(String username);
}
