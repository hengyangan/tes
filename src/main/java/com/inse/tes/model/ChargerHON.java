package com.inse.tes.model;

import lombok.Data;

@Data
public class ChargerHON {
    private String chargerID;
    private String chargerManuf = "HELOX";
    private String chargerModel = "ON";
    private Integer chargerSpeed = 50;

}
