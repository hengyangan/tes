package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class ChargerAON extends Charger{
    private String chargerID;
    private String chargerManuf = "ABB";
    private String chargerModel = "ON-100";
    private Integer chargerSpeed = 100;
    private String position;
    private LinkedList<Integer> chargStartTime = new LinkedList<>();
    private LinkedList<Integer> chargEndTime = new LinkedList<>();
    private LinkedList<Integer> String = new LinkedList<>();
    private LinkedList<Integer> nextTrip = new LinkedList<>();
}
