package com.in28minutes.learnspringframework;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // Launch the Spring Context
        var context = new AnnotationConfigReactiveWebApplicationContext(HelloWorldConfiguration.class);
        // CConfigure the  things that we want to spring manage -  @Configuration
        //HelloWorldConfiguration -  @Configuration
        //name -@Bean

        //3. Retrieve the bean mapped by Spring
        System.out.println(context.getBean("name"));

        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));

        System.out.println(context.getBean("person2MethodCall"));

        System.out.println(context.getBean("person3Parameters"));

        System.out.println(context.getBean("address2"));

//        System.out.println(context.getBean(Address.class));

    }
}
