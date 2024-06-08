package ir.maktabsharif.entity;

public class User extends BaseEntity{
    public static final String TABLE_NAME = "users";
    private String username;
    private String password;

// java 23 ,24 use super and this anywhere
    public User( String username, String password) {
        initUser(username,password);
    }
    public User(Long id , String username, String password) {
        super(id);
        initUser(username,password);
    }
    private void initUser( String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return STR."User{username='\{username}\{'\''}, password='\{password}\{'\''}\{'}'}";
    }
}
