package com.in28minutes.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyAssertTest {
    private final MyMath myMath = new MyMath();

    List<String> todos = Arrays.asList("AWS", "Spring", "Spring Boot", "Docker", "Kubernetes", "Microservices", "Jenkins", "Maven", "Gradle", "Git");


    @Test
    void test() {
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("AWSABC");
      //  assertEquals(true, test);
        assertTrue(test, "Something went wring");
        assertFalse(test2);

        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3,4});

        assertEquals(10, todos.size(), "Size of the list is not 10");

    }
}