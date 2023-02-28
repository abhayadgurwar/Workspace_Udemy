package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Released in JDK 16
record Person(String name, int age, Address address) { }

record Address(String firstLine, String city) { }
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Abhay";
    }

    @Bean
    public int age() {
        return 30;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Near Orvi Socity", "Balewadi") );
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
//        return new Person(name(), age(), address());
        return new Person(name, age, address3);
    }

    @Bean (name = "address2")
    public Address address() {
        return new Address("A402, Favolosa", "Pune");
    }

    @Bean (name = "address3")
    public Address address3() {
        return new Address("Behind MITCON", "Baner");
    }

}
