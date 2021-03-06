package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class BigBus extends Bus{
    public Integer busID;
    public String model = "Big size model";
    public Integer size = 394;
    public String position;
    private LinkedList<Integer> atSoc = new LinkedList<>();
    private LinkedList<Integer> btSoc = new LinkedList<>();
    private LinkedList<Integer> chargerID = new LinkedList<>();
    private LinkedList<Integer> chargerStartTime = new LinkedList<>();
    private LinkedList<Integer> chargerEndTime = new LinkedList<>();
    private LinkedList<String> tripID = new LinkedList<>();
    private LinkedList<Integer> tripStartTime = new LinkedList<>();
    private LinkedList<Integer> tripEndTime = new LinkedList<>();
//
//    public BigBus(Integer busID,Integer leftSize){
//        this.busID = busID;
//        this.leftSize.add(leftSize);
//    }

}
