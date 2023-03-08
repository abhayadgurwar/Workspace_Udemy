package programming;

import java.util.stream.LongStream;

public class FP74Parallelizing {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();

        System.out.println(
                LongStream.range(0, 1000000000)
                        .parallel()
                        .sum()
        );

        System.out.println(System.currentTimeMillis()-timeStart);
    }
}
