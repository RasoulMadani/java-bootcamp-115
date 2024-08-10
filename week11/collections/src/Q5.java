import java.util.HashMap;
import java.util.Map;

public class Q5 {
    public static void main(String args[]) {
        HashMap<Integer,String> hash_map= new HashMap<Integer,String>();
        hash_map.put(11, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Black");
        hash_map.put(4, "White");
        hash_map.put(5, "Blue");
        System.out.println(hash_map.entrySet());
        System.out.println(hash_map.values());
        for(Map.Entry x : hash_map.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue());
        }
    }
}
