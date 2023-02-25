package programming;

import java.util.List;

public class FP05Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        distinctListFunctional(numbers);
        System.out.println("-------------------------------");
        sortedListFunctional(numbers);
        System.out.println("-------------------------------");

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        distinctCourseListFunctional(courses);
        System.out.println("-------------------------------");
        sortedCourseListFunctional(courses);
        System.out.println("-------------------------------");
    }
    private static void distinctListFunctional(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void sortedListFunctional(List<Integer> numbers) {
        numbers.stream()
                .sorted().distinct()
                .forEach(System.out::println);
    }

    private static void distinctCourseListFunctional(List<String> course) {
        course.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void sortedCourseListFunctional(List<String> course) {
        course.stream()
                .sorted().distinct()
                .forEach(System.out::println);
    }


}
