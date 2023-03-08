package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {

    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependency are ready");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("SomeClass is initialized");
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Cleanup is called");
    }

}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostAnnotationContextLauncherApplication.class)) {
            System.out.println("------------Beans------------");

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }


}
