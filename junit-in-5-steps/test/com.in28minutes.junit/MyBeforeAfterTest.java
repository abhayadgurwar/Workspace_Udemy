package com.in28minutes.junit;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Before each");
    }
    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }


    @Test
    void test3() {
        System.out.println("Test 3");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }
}