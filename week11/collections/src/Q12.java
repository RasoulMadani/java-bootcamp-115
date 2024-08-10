import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q12 {
    public static void main(String[] args) {

        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2); // 0 2 4
        iterate.takeWhile(x -> x < 1000).forEach(System.out::println); //limit




        IntPredicate predicate= x-> {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if(x%i==0){
                    return false;
                }
            }
            return true;
        };
        IntStream.iterate(2, x -> x < 1000, x -> x + 1)
//                .takeWhile(x -> x < 1000)
                .filter(predicate)
                .forEach(System.out::println);

        IntStream.iterate(6, x -> x + 1)
                .filter(predicate)
                .filter(x->x<1000)
                .findFirst()
                .ifPresent(System.out::println);

    }

}

