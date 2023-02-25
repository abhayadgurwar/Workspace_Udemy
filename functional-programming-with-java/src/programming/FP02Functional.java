package programming;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addListFunctional(numbers);
        System.out.println(sum);
    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
//               .reduce(0, FP02Functional::sum); // By calling sum method
//                .reduce(0, (x,y) -> x+y); // Sum can be used inside reduce
                .reduce(0, Integer::sum);  // easy approach by in build methods
    }
}
