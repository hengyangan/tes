package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class ChargerAOC extends Charger{
    private String chargerID;
    private String chargerManuf = "ABB";
    private String chargerModel = "OC-300";
    private Integer chargerSpeed = 300;
    private String position;
    private LinkedList<Integer> chargStartTime = new LinkedList<>();
    private LinkedList<Integer> chargEndTime = new LinkedList<>();
    private LinkedList<Integer> String = new LinkedList<>();
    private LinkedList<Integer> nextTrip = new LinkedList<>();
}
