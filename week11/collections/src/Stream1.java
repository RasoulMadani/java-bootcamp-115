import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        List<String> nums = Arrays.asList("b allAh","alLah2");
        List<Integer> nums1 = Arrays.asList(1,2,3,4,5,6,6);

        System.out.println("list of numbers : " + nums);

         Long count1 = nums.stream()
                            .filter(num-> num.startsWith("a"))
                            .count();


        nums.stream().sorted(Comparator.reverseOrder())
                        .forEach(System.out::println);
        System.out.println(count1);

        int odd = nums1.stream()
                        .filter(num-> num%2 != 0)
                        .reduce(0, Integer::sum);


         nums1.stream().distinct().forEach(System.out::println);

        Integer secondLargest = nums1.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondLargest);
    }
}


