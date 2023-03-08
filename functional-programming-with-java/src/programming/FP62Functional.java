package programming;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FP62Functional {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y);

        System.out.println(LongStream.rangeClosed(1, 20).reduce(1L, (x, y) -> x * y));


        System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
