package Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Amir","Hatef","Mahdi","Mojtaba"
            ,"Mohammad","Ali","Taher","Reza","Mohsen"
        ));
       Map<Integer,List<String>> result = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result);

//        {3=[Ali], 4=[Amir, Reza], 5=[Hatef, Mahdi, Taher], 6=[Mohsen], 7=[Mojtaba], 8=[Mohammad]}
    }
}
