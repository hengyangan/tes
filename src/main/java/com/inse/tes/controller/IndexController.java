package com.inse.tes.controller;

import com.inse.tes.model.*;
import com.inse.tes.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    Service service = new Service();

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("index")
    public String getChargerInput(@RequestParam(value = "modelHOCInput",required = false,defaultValue = "0") Integer modelHOCInput,
                                  @RequestParam(value = "modelHONInput",required = false,defaultValue = "0") Integer modelHONInput,
                                  @RequestParam(value = "modelAOCInput",required = false,defaultValue = "0") Integer modelAOCInput,
                                  @RequestParam(value = "modelAONInput",required = false,defaultValue = "0") Integer modelAONInput,
                                  @RequestParam(value = "smallBusInput",required = false,defaultValue = "0") Integer smallBusInput,
                                  @RequestParam(value = "bigBusInput",required = false,defaultValue = "0") Integer bigBusInput){

        if (modelHOCInput!=null||modelHOCInput!=0){
//            ChargerHOC chargerHOC = new ChargerHOC();
            service.getHinfo().add(modelHOCInput);
        }
        if (modelHONInput!=null||modelHONInput!=0){
//            ChargerHON chargerHON = new ChargerHON();
            service.getHinfo().add(modelHONInput);
        }
        if (modelAOCInput!=null||modelAOCInput!=0){
//            ChargerAOC chargerAOC = new ChargerAOC();
            service.getAinfo().add(modelAOCInput);
        }
        if (modelAONInput!=null||modelAONInput!=0){
//            ChargerAON chargerAON = new ChargerAON();
            service.getAinfo().add(modelAONInput);
        }
        if (smallBusInput!=null||smallBusInput!=0){
//            SmallBus smallBus = new SmallBus();
            service.setBusUnitCost(smallBusInput);
        }
        if (bigBusInput!=null||bigBusInput!=0){
//            BigBus bigBus = new BigBus();
            service.setBusUnitCost(bigBusInput);
        }

//        System.out.println(smallBusInput +"" +bigBusInput);
        return "index";
    }
}
