import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = LambdaUtil.helloSupplier();
        System.out.println(helloSupplier.get());//Hello

        Predicate<String> isEmptyPredicate = LambdaUtil.isEmptyPredicate();

        System.out.println(isEmptyPredicate.test("java"));//false
        System.out.println(isEmptyPredicate.test(""));//true

        BiFunction<String, Integer, String> stringMultiplier = LambdaUtil.stringMultiplier();
        System.out.println(stringMultiplier.apply("Hi", 3));//HiHiHi

        Function<BigDecimal, String> toDollarStringFunction = LambdaUtil.toDollarStringFunction();
        String tenDollarStr = toDollarStringFunction.apply(BigDecimal.TEN.setScale(2));
        System.out.println(tenDollarStr);//$10.00

        Predicate<String> lengthInRangePredicate = LambdaUtil.lengthInRangePredicate(4, 8);
        System.out.println(lengthInRangePredicate.test("Hello world"));//false

        IntSupplier randomIntSupplier = LambdaUtil.randomIntSupplier();
        int firstValue = randomIntSupplier.getAsInt();
        int secondValue = randomIntSupplier.getAsInt();
        System.out.println(firstValue == secondValue);//false

        IntUnaryOperator boundedRandomIntSupplier = LambdaUtil.boundedRandomIntSupplier();
        int randomIntLessThan1000 = boundedRandomIntSupplier.applyAsInt(1000);
        System.out.println(randomIntLessThan1000 < 1000);//true

        IntUnaryOperator squareOperation = LambdaUtil.intSquareOperation();
        System.out.println(squareOperation.applyAsInt(4));//16

        LongBinaryOperator sumOperation = LambdaUtil.longSumOperation();
        System.out.println(sumOperation.applyAsLong(5, -10));//-5

        ToIntFunction<String> stringToIntConverter = LambdaUtil.stringToIntConverter();
        int num = stringToIntConverter.applyAsInt("234");
        System.out.println(num);//234

        Supplier<IntUnaryOperator> fiveMultiplyFunctionSupplier = LambdaUtil.nMultiplyFunctionSupplier(5);
        IntUnaryOperator multiplyByFiveOperation = fiveMultiplyFunctionSupplier.get();
        int result = multiplyByFiveOperation.applyAsInt(11);
        System.out.println(result);//11 * 5 => 55

        Supplier<Supplier<Supplier<String>>> wellDoneSupplier = LambdaUtil.trickyWellDoneSupplier();
        System.out.println(wellDoneSupplier.get().get().get());//WELL DONE!

        UnaryOperator<Function<String, String>> composeWithTrimFunction = LambdaUtil.composeWithTrimFunction();
        Function<String, String> toLowerWithTrim = composeWithTrimFunction.apply(String::toLowerCase);
        System.out.println(toLowerWithTrim.apply("  Hey "));//hey

        //extra points
        BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> intFunctionToConditionalIntFunction
                = LambdaUtil.functionToConditionalFunction();
        IntUnaryOperator abs = intFunctionToConditionalIntFunction.apply(a -> -a, a -> a < 0);
        System.out.println(abs.applyAsInt(-5));//5

        BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader = LambdaUtil.functionLoader();
        Map<String, IntUnaryOperator> functionMap = new HashMap<>();
        functionMap.put("increment", x -> x + 1);
        functionMap.put("square", x -> x * x);

        IntUnaryOperator incrementFunction = functionLoader.apply(functionMap, "increment");
        IntUnaryOperator squareFunction = functionLoader.apply(functionMap, "square");
        IntUnaryOperator identityFunction = functionLoader.apply(functionMap, "none");

        System.out.println(incrementFunction.applyAsInt(4));//5
        System.out.println(squareFunction.applyAsInt(3));//9
        System.out.println(identityFunction.applyAsInt(10));//10
    }

}
