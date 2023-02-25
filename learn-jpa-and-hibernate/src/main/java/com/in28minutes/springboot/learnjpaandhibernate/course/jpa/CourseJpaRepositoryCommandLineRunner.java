package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaRepositoryCommandLineRunner implements CommandLineRunner {

     @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======================================= JPA =======================================");
        repository.insert(new Course(10001L, "AWS in 100 Jpa", "Ranga"));
        repository.insert(new Course(10002L, "Azure in 100 Jpa", "Ranga"));
        repository.insert(new Course(10003L, "DevOps in 100 Jpa", "Ranga"));

        repository.deleteById(10001L);

        System.out.println(repository.findById(10002L));

        System.out.println(repository.findById(10002L));
    }

}
