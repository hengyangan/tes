package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class Charger{
    private String chargerID;
    private String chargerManuf;
    private String chargerModel;
    private Integer chargerSpeed;
    private LinkedList<Integer> chargStartTime = new LinkedList<>();
    private LinkedList<Integer> chargEndTime = new LinkedList<>();
    private LinkedList<Integer> String = new LinkedList<>();
    private LinkedList<Integer> nextTrip = new LinkedList<>();
}
