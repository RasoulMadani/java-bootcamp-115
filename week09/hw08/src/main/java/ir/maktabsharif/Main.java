package ir.maktabsharif;

import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.repository.user.UserRespositoryImpl;
import ir.maktabsharif.service.user.UserService;
import ir.maktabsharif.service.user.UserServiceImpl;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.config.DataSource;
import ir.maktabsharif.util.menu.Menu;

import java.sql.Connection;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();
        applicationContext.getMenu().show();

    }
}
