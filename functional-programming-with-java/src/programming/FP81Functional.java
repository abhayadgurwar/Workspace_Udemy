package programming;

import java.util.ArrayList;
import java.util.List;

public class FP81Functional {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        List<String> modifyableCourses = new ArrayList(courses);

        modifyableCourses.replaceAll(str -> str.toUpperCase());
        //[SPRING, SPRING BOOT, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES]

        modifyableCourses.removeIf(course -> course.length() < 6);
        //[SPRING, SPRING BOOT, MICROSERVICES, DOCKER, KUBERNETES]

        System.out.println(modifyableCourses);


    }

}
