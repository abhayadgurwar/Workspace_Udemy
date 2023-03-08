package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP71Functional {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(
                courses.stream()
                        .collect(Collectors.joining(" "))
        );
//        Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes

        System.out.println(
                courses.stream()
                        .collect(Collectors.joining(", "))
        );
//        Spring, Spring Boot, API, Microservices, AWS, PCF, Azure, Docker, Kubernetes
        System.out.println(
                courses.stream()
                        .map(course -> course.split(""))
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );
//        [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

        System.out.println(
                courses.stream()
                        .map(course -> course.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList())
        );
//        [S, p, r, i, n, g,  , B, o, t, A, P, I, M, c, s, e, v, W, C, F, z, u, D, k, K, b]

        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println(
                courses.stream()
                        .flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length()).map(course2 -> List.of(course, course2)))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );
//[[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]


        Predicate<Course> reviewScoreGreaterThan95Predicate2
                = createPredicateWithCutOffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2
                = createPredicateWithCutOffReviewScore(90);

        System.out.println(
                courses.stream()
                        .filter(course -> course.length() > 11)
                        .map(String::toUpperCase).findFirst()
        );
//        Optional[MICROSERVICES]

        System.out.println(
                courses.stream()
                        .peek(System.out :: println) // to print the result set till this line
                        .filter(course -> course.length() > 11)
                        .peek(System.out :: println)
                        .map(String::toUpperCase)
                        .findFirst()
                        //.forEach(System.out::println)
        );
    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }
}
