package programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //allMatch,  NoneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

//        TODO:: Practice for ReviewScore

        // Comparator

        Comparator comparingByNoOfStudentsIncreasing
                = Comparator.comparingInt(Course::getNoOfStudents);

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList())
        );
//        [Course{name='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}, Course{name='FullStack', reviewScore=91, noOfStudents=14000}]

        Comparator comparingByNoOfStudentsDecreasing
                = Comparator.comparingInt(Course::getNoOfStudents)
                .reversed();

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList())
        );
//        [Course{name='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}, Course{name='FullStack', reviewScore=91, noOfStudents=14000}]

        Comparator comparingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList())
        );
//    [Course{name='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}, Course{name='FullStack', reviewScore=91, noOfStudents=14000}]

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList())
        );
//[Course{name='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList())
        );
//[Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}, Course{name='FullStack', reviewScore=91, noOfStudents=14000}]

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );
//        [Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}]

//          takeWhile                       dropWhile
        System.out.println("List -> " + courses);

//        [Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}, Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}]

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews)
        );
//        Optional[Course{name='FullStack', reviewScore=91, noOfStudents=14000}]

        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndNoOfReviews)
        );
//        Optional[Course{name='Microservices', reviewScore=96, noOfStudents=25000}]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );
//        Optional: Empty - If result is null

//        Course{name='Microservices', reviewScore=96, noOfStudents=25000}  // Due to orElse block

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        );
//        Optional[Course{name='Spring', reviewScore=98, noOfStudents=20000}]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );
//Optional[Course{name='Spring', reviewScore=98, noOfStudents=20000}]
        System.out.println("-------------------------------------------");

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum());
//        88000

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average());
// OptionalDouble[22000.0]
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count());
//        4

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max());
        // OptionalInt [25000]

        System.out.println("========================================");
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );
/*        {
            Cloud=[Course{name='AWS', reviewScore=92, noOfStudents=21000}, Course{name='Azure', reviewScore=99, noOfStudents=21000}, Course{name='Docker', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', reviewScore=91, noOfStudents=20000}],
            FullStack=[Course{name='FullStack', reviewScore=91, noOfStudents=14000}],
            Microservices=[Course{name='API', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', reviewScore=96, noOfStudents=25000}],
            Framework=[Course{name='Spring', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', reviewScore=95, noOfStudents=18000}]
        }*/

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );
//        {Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course :: getReviewScore)))));
//        {Cloud=Optional[Course{name='Azure', reviewScore=99, noOfStudents=21000}],
//        FullStack=Optional[Course{name='FullStack', reviewScore=91, noOfStudents=14000}],
//        Microservices=Optional[Course{name='API', reviewScore=97, noOfStudents=22000}],
//        Framework=Optional[Course{name='Spring', reviewScore=98, noOfStudents=20000}]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course ::getName, Collectors.toList()))));

//        {Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}?





    }
}
