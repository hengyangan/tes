package com.inse.tes.model;

import lombok.Data;

@Data
public class ChargerAON {
    private String chargerID;
    private String chargerManuf = "ABB";
    private String chargerModel = "ON";
    private Integer chargerSpeed = 100;
}
