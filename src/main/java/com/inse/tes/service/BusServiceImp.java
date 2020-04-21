package com.inse.tes.service;

import com.inse.tes.mapper.BusScheduleMapper;
import com.inse.tes.model.Bus;
import com.inse.tes.model.ChargerAOC;
import com.inse.tes.model.ChargerAON;
import com.inse.tes.model.SmallBus;
import com.inse.tes.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusServiceImp implements BusService {
    public Util util = new Util();
    @Autowired
    BusScheduleMapper busScheduleMapper;

    @Override
    public void chargerABusSmallService(Integer modelAOCInput, Integer modelAONInput, Integer smallBusInput) {
        List<Integer> westBusSchedule = busScheduleMapper.westList();
        List<Integer> eastBusSchedule = busScheduleMapper.eastList();
//        List<Bus> westBusList = new ArrayList<>();
//        List<Bus> eastBusList = new ArrayList<>();
//        for (int i = 0; i < westBusSchedule.size(); i++) {
//            westBusList.add(new SmallBus());
//            westBusList.get(i).getAtSoc().add(294);
//            westBusList.get(i).getBtSoc().add(294);
//            westBusList.get(i).setPosition("WEST");
//        }
//        for (int i = 0; i < eastBusSchedule.size(); i++) {
//            eastBusList.add(new SmallBus());
//            eastBusList.get(i).getAtSoc().add(294);
//            eastBusList.get(i).getBtSoc().add(294);
//            eastBusList.get(i).setPosition("EAST");
//        }
        List<ChargerAOC> westStationAOC = new ArrayList<>();
        List<ChargerAOC> eastStationAOC = new ArrayList<>();
        while (eastBusSchedule.size() >0) {
            Integer departureTime = eastBusSchedule.get(0);
            Bus smallBus = new SmallBus();
            smallBus.getAtSoc().add(294);
            smallBus.getBtSoc().add(294);
            smallBus.setPosition("EAST");
            util.departure(smallBus, departureTime, westBusSchedule, eastBusSchedule);
        }
        while (westBusSchedule.size()>0){
            Integer departureTime = westBusSchedule.get(0);
            Bus smallBus = new SmallBus();
            smallBus.getAtSoc().add(294);
            smallBus.getBtSoc().add(294);
            smallBus.setPosition("WEST");
            util.departure(smallBus,departureTime,westBusSchedule,eastBusSchedule);
        }
    }


    @Override
    public void chargerABusBigService(Integer modelAOCInput, Integer modelAONInput, Integer bigBusInput) {

    }

    @Override
    public void chargerHBusSmallService(Integer modelHOCInput, Integer modelHONInput, Integer smallBusInput) {

    }

    @Override
    public void chargerHBusBigService(Integer modelHOCInput, Integer modelHONInput, Integer bigBusInput) {

    }
}
