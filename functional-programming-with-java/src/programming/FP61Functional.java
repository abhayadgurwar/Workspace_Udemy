package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP61Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println(numbers.stream());

        int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};

        System.out.println(Arrays.stream(numberArray));

        System.out.println(Arrays.stream(numberArray).sum());

        System.out.println(Arrays.stream(numberArray).max());

        System.out.println(Arrays.stream(numberArray).min());


        System.out.println(IntStream.range(1, 10).sum());

        System.out.println(IntStream.rangeClosed(1, 10).sum());

        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).sum());

        System.out.println(IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println).sum());

        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());


        System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList()));


    }
}
