package com.in28minutes.rest.webservices.restfulwebservices;

public class HelloWorldBean {
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public HelloWorldBean(String message) {
        this.message =  message;
    }
}

