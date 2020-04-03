package com.inse.tes.model;

import lombok.Data;

@Data
public class ChargerHOC {
    private String chargerID;
    private String chargerManuf = "HELOX";
    private String chargerModel = "OC";
    private Integer chargerSpeed = 450;

}
