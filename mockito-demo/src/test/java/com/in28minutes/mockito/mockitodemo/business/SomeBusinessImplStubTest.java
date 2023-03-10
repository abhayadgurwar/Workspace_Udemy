package com.in28minutes.mockito.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFormAllData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGraetestFromData();
//        System.out.println(result);
        assertEquals(24, result);
    }
    @Test
    void findTheGreatestFormAllData_withOneValue() {
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGraetestFromData();
//        System.out.println(result);
        assertEquals(35, result);
    }

    class DataServiceStub1 implements DataService {
        @Override
        public int[] retrieveAllData() {
            return new int[]{24, 6, 15};
        }
    }

    class DataServiceStub2 implements DataService {
        @Override
        public int[] retrieveAllData() {
            return new int[]{35};
        }
    }
}
