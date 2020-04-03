package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ChargerAOC {
    private String chargerID;
    private String chargerManuf = "ABB";
    private String chargerModel = "OC";
    private Integer chargerSpeed = 300;
    private ArrayList<Integer> chargStartTime = new ArrayList<>();
    private ArrayList<Integer> chargEndTime = new ArrayList<>();
    private ArrayList<Integer> String = new ArrayList<>();
    private ArrayList<Integer> nextTrip = new ArrayList<>();
}
