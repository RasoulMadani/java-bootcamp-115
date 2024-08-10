import java.util.*;

// 2. Write a Java program to iterate through all elements in an array list.
public class Q3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("123","012","allah","allah2"));
//        list.addFirst("karim");

//        ArrayList<String> list2 = new ArrayList<>(list);
        ArrayList<String> list2 = (ArrayList<String>) ((ArrayList<String>) list).clone();
        System.out.println(list2);

    }
}
