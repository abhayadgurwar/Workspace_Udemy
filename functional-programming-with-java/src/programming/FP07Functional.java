package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP07Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> doubledList = doubledList(numbers);
        System.out.println(doubledList);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
    }

    private static List<Integer> doubledList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }
}
