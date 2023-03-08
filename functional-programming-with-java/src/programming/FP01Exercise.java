package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP01Exercise {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        //        Exercise - 10
        List<Integer> EvenNumbers = CreateListFilteredWithEvenNumbers(numbers);
        //  System.out.println(EvenNumbers);
        //              Exercise - X
//        printOddNumbersInListFunctional(numbers);
        //              Exercise - 5

//        printCubeOfOddNumbersInListFunctional(numbers);

//              Exercise - 7
        int sum2 = printSumOfSquareOfAllNumbersInList(numbers);
//        System.out.println(sum2);

//      Exercise - 8
        int sum3 = printSumOfCubeOfAllNumbersInList(numbers);
//        System.out.println(sum3);

        //      Exercise - 9
        int sumOdd = printSumOfAllOddNumbersInList(numbers);
//        System.out.println(sumOdd);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

   /*     courses.stream()
                .forEach(System.out :: println);*/

//        printCoursesWithSpringInListFunctional(courses);
        //              Exercise - 4
//        printCoursesWhoseLengthIs4ListFunctional(courses);
        //              Exercise - 6
//        printNumberOfCharOfCourseInListFunctional(courses);

        //        Exercise - 11
        List<Integer> courseLength = createListOfCourseLength(courses);
        System.out.println(courseLength);


    }

    private static List<Integer> createListOfCourseLength(List<String> courses) {
        return courses.stream()
                .map(course -> course.length())
                .collect(Collectors.toList());
    }

    private static List<Integer> CreateListFilteredWithEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }


    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printCoursesWithSpringInListFunctional(List<String> courses) {
        courses.stream().
                filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCoursesWhoseLengthIs4ListFunctional(List<String> courses) {
        courses.stream().
                filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }

    private static void printNumberOfCharOfCourseInListFunctional(List<String> courses) {
        courses.stream()
                .map(course -> course + "-> " + course.length())
                .forEach(System.out::println);
    }

    private static int printSumOfCubeOfAllNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
    }

    private static int printSumOfSquareOfAllNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
    }

    private static int printSumOfAllOddNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum);
    }

}
