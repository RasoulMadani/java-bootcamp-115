import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q1 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(new Integer[]{3,5,18,4,6}));
        System.out.println(list);list.remove(Integer.valueOf(3));
        Integer min = Collections.min(list);
        Integer max = Collections.max(list);
        System.out.println(list.size());
        System.out.println(min +  " " + max);
    }

}
