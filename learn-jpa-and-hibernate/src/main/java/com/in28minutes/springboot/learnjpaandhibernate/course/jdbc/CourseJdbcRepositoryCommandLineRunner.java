package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======================================= JDBC =======================================");

        repository.insert(new Course(10001L, "AWS in 100 steps", "Ranga"));
        repository.insert(new Course(10002L, "Azure in 100 steps", "Ranga"));
        repository.insert(new Course(10003L, "DevOps in 100 steps", "Ranga"));

        repository.deleteById(10001L);

        System.out.println(repository.findById(10002L));

        System.out.println(repository.findById(10002L));
    }

}
