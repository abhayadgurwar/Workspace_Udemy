package programming;

import java.util.Comparator;
import java.util.List;

public class FP06Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println("--------------Comparator in Natural Order-----------------");
//        sortedComparatorCourseListFunctional(courses);
        System.out.println("--------------Comparator in Reverse Order-----------------");
//        sortedComparatorCourseReverseListFunctional(courses);
        System.out.println("--------------Sort as per course Length-----------------");
        sortedComparatorCoursAsPerCourseLengthListFunctional(courses);
    }

    private static void sortedComparatorCourseListFunctional(List<String> course) {
        course.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static void sortedComparatorCourseReverseListFunctional(List<String> course) {
        course.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void sortedComparatorCoursAsPerCourseLengthListFunctional(List<String> course){
        course.stream()
               // .map(cour -> cour.length())
                .sorted(Comparator.comparing(str -> str.length()))
                .forEach(System.out :: println);
    }


}
