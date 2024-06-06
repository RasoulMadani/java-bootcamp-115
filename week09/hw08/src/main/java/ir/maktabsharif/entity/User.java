package ir.maktabsharif.entity;

public class User extends BaseEntity{
    public static final String TABLE_NAME = "users";
    private String username;
    private String password;


    public User( String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(Long id , String username, String password) {
        super(id);
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
