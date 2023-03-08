package com.in28minutes.learnspringframework.examples.h1;

import com.in28minutes.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


@Configuration
@ComponentScan
public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {
        try (var context =
                     new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            System.out.println("------------Beans Start------------");

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("------------Beans End------------");

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            context.getBean(GameRunner.class).run();
        }
    }
}
