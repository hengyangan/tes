package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SmallBus {
    private String busID;
    private String model= "Big size model";
    private Integer size = 394;
    private Integer leftSize;
    private ArrayList<String> tripComp = new ArrayList<>();
    private ArrayList<Integer> atSoc = new ArrayList<>();
    private ArrayList<Integer> btSoc = new ArrayList<>();
    private ArrayList<Integer> chargerID = new ArrayList<>();
    private ArrayList<Integer> startTime = new ArrayList<>();
    private ArrayList<Integer> endTime = new ArrayList<>();
    private ArrayList<String> tripID = new ArrayList<>();
    private ArrayList<Integer> tripStartTime = new ArrayList<>();
    private ArrayList<Integer> tripEndTime = new ArrayList<>();

    public void SmallBus(String busID,Integer leftSize){
        this.busID = busID;
        this.leftSize = leftSize;
    }
}
