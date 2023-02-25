package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaRepositoryCommandLineRunner implements CommandLineRunner {

     @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======================================= Spring Data Jpa =======================================");
        repository.save(new Course(10001L, "AWS in 100 Spring Data Jpa", "Ranga"));
        repository.save(new Course(10002L, "Azure in 100 Spring Data Jpa", "Ranga"));
        repository.save(new Course(10003L, "DevOps in 100 Spring Data Jpa", "Ranga"));

        repository.deleteById(10001L);

        System.out.println(repository.findById(10002L));

        System.out.println(repository.findById(10002L));

        System.out.println(repository.findAll());

        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Ranga"));
        System.out.println(repository.findByAuthor("Ranga"));


        System.out.println(repository.findByName("AWS in 100 Spring Data Jpa"));
        System.out.println(repository.findByName("DevOps in 100 Spring Data Jpa"));

    }

}
