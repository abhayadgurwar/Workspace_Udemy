package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    private static void display(String stri){
        System.out.println(stri);
    }
    public static void main(String[] args) {


        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

     /*   courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out :: println);*/

          /* courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(FP03MethodReferences::display);*/

        courses.stream()
                .map(String :: toUpperCase)
                .forEach(FP03MethodReferences::display);

        Supplier<String> supplier1 = () -> new String();

        Supplier<String> supplier2 = String :: new;
    }



}
