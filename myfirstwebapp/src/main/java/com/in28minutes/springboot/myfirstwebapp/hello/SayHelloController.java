package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {

        String sb = "<html>" +
                "<head>" +
                "<title>Hello</title>" +
                "</head>" +
                "<body>" +
                "<h1>Hello! What are you learning today</h1>" +
                "</body>" +
                "</html>";


        return sb;
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
