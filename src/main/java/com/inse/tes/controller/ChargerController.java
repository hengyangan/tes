package com.inse.tes.controller;

import com.inse.tes.model.ChargerAOC;
import com.inse.tes.model.ChargerAON;
import com.inse.tes.model.ChargerHOC;
import com.inse.tes.model.ChargerHON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ChargerController {

    @RequestMapping("")
    public String chargerSelect() {
        return "select-charger";
    }


}
