package com.in28minutes.mockito.mockitodemo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGraetestFromData() {
        int[] data =  dataService.retrieveAllData();
        int gratestValue =Integer.MIN_VALUE;
        for(int val : data){
            if(val > gratestValue){
                gratestValue = val;
            }
        }
        return gratestValue;
    }
}

interface DataService {
    int[] retrieveAllData();

}