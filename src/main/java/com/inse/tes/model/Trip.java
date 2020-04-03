package com.inse.tes.model;

import lombok.Data;

import java.util.Date;

@Data
public class Trip {
    private String tripID;
    private Integer tripStartTime;
    private Integer tripEndTime;
}
