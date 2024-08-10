package Q2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Amir","Hatef","Mahdi","Mojtaba"
            ,"Mohammad","Ali","Taher","Reza","Mohsen"
        ));
        List<String>sortedList =  list.stream().sorted().toList();
        List<String>reverseOrderList =  list.stream().sorted(Comparator.reverseOrder()).toList();

        List<String>orderByLengthList =  list.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sortedList);
        System.out.println(reverseOrderList);
        System.out.println(orderByLengthList);

        Map<Integer,String> result = list.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(",")));
        System.out.println(result);
        System.out.println(result.values());


//        {3=[Ali], 4=[Amir, Reza], 5=[Hatef, Mahdi, Taher], 6=[Mohsen], 7=[Mojtaba], 8=[Mohammad]}
    }
}
