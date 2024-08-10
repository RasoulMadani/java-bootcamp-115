import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 2. Write a Java program to iterate through all elements in an array list.
public class Q2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("allah","allah2"));
        for (String l : list){
            System.out.println(l);
        }
    }
}
