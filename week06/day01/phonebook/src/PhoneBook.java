import java.util.Arrays;

public class PhoneBook {
    private  DynamicArray users = new DynamicArray();

    public void addUser(User user){
            users.add(user);
            System.out.println(users);
    }
    public User[] searchUser(String search){
        Object[] array = users.get();
        DynamicArray users = new DynamicArray();
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                 User user = (User) array[i];
               if(user.getName().contains(search)){
                   users.add(array[i]);
               };
            }
        }
        User[] users1 = new User[users.size()];
        for (int i = 0; i < users.size(); i++) {
            users1[i] = (User) users.get()[i];
        }
        return users1;
    }

//    public void removeUser(String name){
//        for (int i = 0; i < users.length; i++) {
//            if(users[i] != null && users[i].getName().equals(name)){
//                users[i] = null;
//                return;
//            }
//        }
//    }
//    public User[] searchUsers(String name){
//        for (int i = 0; i < users.length; i++) {
//
//        }
//    }

}
