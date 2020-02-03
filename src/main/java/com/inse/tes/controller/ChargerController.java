package com.inse.tes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChargerController {
    @RequestMapping("")
    public String chargerSelect() {
        return "select-charger";
    }
}
