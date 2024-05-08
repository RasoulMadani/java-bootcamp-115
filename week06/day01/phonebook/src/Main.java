import java.util.Scanner;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    """
                            add : 1
                            remove : 2
                            edit : 3
                            search : 4
                            """);
            int command = scanner.nextInt();
            switch (command) {
                case 1 ->addUser( );
//                case 2 ->
                case 3 ->editUser();
                case 4 ->searchUser();

            }

        }

    }

    public static void addUser() {
        System.out.println("Enter name user : ");
        String name = scanner.next();
        System.out.println("Enter phone user : ");
        String phone = scanner.next();
        User user = new User(name, phone);
        phoneBook.addUser(user);
        System.out.println(phoneBook);
    }
//    public static void removeUser(){
//        System.out.println("Enter name of User : ");
//        String name = scanner.next();
//        phoneBook.removeUser(name);
//        System.out.println(phoneBook);
//    }
    public static void editUser(){

    }
    public static  void searchUser(){
        System.out.println("Enter search characters :");
        String search = scanner.next();
        User[] users = phoneBook.searchUser(search);
        for (int i = 0; i < users.length; i++) {
            System.out.println((i+1) + " " + users[i].getName());
        }
    }
}
