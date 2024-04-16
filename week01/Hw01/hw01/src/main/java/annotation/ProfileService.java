package annotation;

@Roles
public class ProfileService {
    @Roles(Post.USER)
    public void  prf_user(){
        System.out.println("Show User Profile");
    }
    @Roles(Post.ADMIN)
    public void  prf_admin(){
        System.out.println("Show Admin Profile");
    }
}
