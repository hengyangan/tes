package com.inse.tes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
public class ChargerHOC extends Charger {
    private String chargerID;
    private String chargerManuf = "HELOX";
    private String chargerModel = "OC-450";
    private Integer chargerSpeed = 450;
    private String position;
    private LinkedList<Integer> chargStartTime = new LinkedList<>();
    private LinkedList<Integer> chargEndTime = new LinkedList<>();
    private LinkedList<Integer> String = new LinkedList<>();
    private LinkedList<Integer> nextTrip = new LinkedList<>();
}
