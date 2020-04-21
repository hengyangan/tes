package com.inse.tes.util;

import com.inse.tes.model.*;

import java.util.LinkedList;
import java.util.List;

public class Util {
    public static Integer chargerCount = 1;
    LinkedList<Bus> busList = new LinkedList();
    LinkedList<ChargerAOC> chargerAOCList = new LinkedList<>();

    public static Integer findNextTrip(Bus bus, List<Integer> westBusSchedule, List<Integer> eastBusSchedule) {
        if (bus.getChargerEndTime().getLast()==null||bus.getChargerEndTime().getLast() <= bus.getTripEndTime().getLast()) {
            Integer tripEndTime = bus.getTripEndTime().getLast();
            if (bus.getPosition().equals("EAST")) {
                for (Integer time : eastBusSchedule) {
                    if (time > tripEndTime) {
                        return time;
                    }
                }
                return -1;
            } else {
                for (Integer time : westBusSchedule) {
                    if (time > tripEndTime) {
                        return time;
                    }
                }
                return -1;
            }
        } else {
            Integer chargerEndTime = bus.getChargerEndTime().getLast();
            if (bus.getPosition().equals("EAST")) {
                for (Integer time : eastBusSchedule) {
                    if (time > chargerEndTime) {
                        return time;
                    }
                }
                return -1;
            } else {
                for (Integer time : westBusSchedule) {
                    if (time > chargerEndTime) {
                        return time;
                    }
                }
                return -1;
            }
        }
    }

    //     to do: hengyang
    public static Integer chargingBus(Bus bus, Charger charger) {

        Integer chargerSpeed = charger.getChargerSpeed() / 60;
        Integer chargerStartTime = bus.getTripEndTime().getLast();
        Integer chargerEndTime = chargerStartTime + (bus.getSize() - bus.getAtSoc().getLast()) / chargerSpeed;
        //设置ID，startTime 和EndTime
        charger.setChargerID(bus.getPosition() + charger.getChargerModel() + chargerCount.toString());
        bus.getChargerStartTime().add(chargerStartTime);
        bus.getChargerEndTime().add(chargerEndTime);
        charger.getChargStartTime().add(chargerStartTime);
        charger.getChargEndTime().add(chargerEndTime);
        chargerCount++;
        return chargerEndTime;
    }

    public void departure(Bus bus, Integer departureTime, List<Integer> westBusSchedule, List<Integer> eastBusSchedule) {
        if (bus.getPosition().equals("EAST")) {
            if (bus.getAtSoc().getLast() > 40) {
                eastBusSchedule.remove(departureTime);
                Integer tripEndTime = departureTime + 60;
                //设置tripStartTime,TripEndTime,ATSOC,chargerStartTime,chargerEndTime
                bus.getTripStartTime().add(departureTime);
                bus.getTripEndTime().add(tripEndTime);
                bus.setPosition("WEST");
                bus.getAtSoc().add(bus.getBtSoc().getLast() - 40);
                bus.getBtSoc().add(bus.getAtSoc().getLast());
                bus.getChargerStartTime().add(null);
                bus.getChargerEndTime().add(null);
                Integer nextTrip = findNextTrip(bus, westBusSchedule, eastBusSchedule);
                if (nextTrip > 0) {
                    departure(bus, nextTrip, westBusSchedule, eastBusSchedule);
                } else {
                    busList.add(bus);
                }
            } else {
                ChargerAOC chargerAOC = findAvailableAOCCharger(chargerAOCList, bus.getTripEndTime().getLast(),bus);
                Integer chargerEndTime = chargingBus(bus, chargerAOC);
                for (Integer nextTrip : eastBusSchedule) {
                    if (nextTrip > chargerEndTime) {
                        departure(bus, nextTrip, westBusSchedule, eastBusSchedule);
                        break;
                    }
                }
            }
        } else if (bus.getPosition().equals("WEST")) {
            if (bus.getAtSoc().getLast() > 40) {
                westBusSchedule.remove(departureTime);
                Integer tripEndTime = departureTime + 60;
                //设置tripStartTime,tripEndTime,ATSOC,chargerStartTime,chargerEndTime
                bus.getTripStartTime().add(departureTime);
                bus.getTripEndTime().add(tripEndTime);
                bus.setPosition("EAST");
                bus.getAtSoc().add(bus.getBtSoc().getLast() - 40);
                bus.getBtSoc().add(bus.getAtSoc().getLast());
                bus.getChargerStartTime().add(null);
                bus.getChargerEndTime().add(null);
                Integer nextTrip = findNextTrip(bus, westBusSchedule, eastBusSchedule);
                if (nextTrip > 0) {
                    departure(bus, nextTrip, westBusSchedule, eastBusSchedule);
                } else {
                    busList.add(bus);
                    return;
                }
            } else {
                ChargerAOC chargerAOC = findAvailableAOCCharger(chargerAOCList, bus.getTripEndTime().getLast(),bus);
                Integer chargerEndTime = chargingBus(bus, chargerAOC);
                for (Integer nextTrip : eastBusSchedule) {
                    if (nextTrip > chargerEndTime) {
                        departure(bus, nextTrip, westBusSchedule, eastBusSchedule);
                        break;
                    }
                }
            }
        }
    }

    public LinkedList<Bus> getBusList() {
        return busList;
    }

    public ChargerAOC findAvailableAOCCharger(LinkedList<ChargerAOC> chargerAOCList, Integer chargerStartTime,Bus bus) {
        ChargerAOC returnedCharger = null;
        if (chargerAOCList.size() == 0) {
            chargerAOCList.add(new ChargerAOC());
        }
        for (ChargerAOC charger : chargerAOCList) {
            if(charger.getChargEndTime().getLast()!=null){
                if(charger.getChargEndTime().getLast()<chargerStartTime){
                    returnedCharger = charger;
                    break;
                }else {
                    chargerAOCList.add(new ChargerAOC());
                    returnedCharger = chargerAOCList.getLast();
                }
            }else {

            }
        }
        return returnedCharger;
    }
//
//    public void chargingHOCSmallBus(SmallBus smallBus, ChargerHOC chargerHOC, Integer startTime, Integer endTime) {
//        Integer leftSize = smallBus.getLeftSize().get(smallBus.getLeftSize().size() - 1);
//        Integer time = endTime - startTime;
//        Integer speed = chargerHOC.getChargerSpeed();
//        leftSize = leftSize + time * speed / 60;
//        smallBus.getLeftSize().add(leftSize);
//    }
//    public void chargingAOCBigBus(BigBus bigBus,ChargerAOC chargerAOC, Integer startTime, Integer endTime){
//        Integer leftSize = bigBus.getLeftSize().get(bigBus.getLeftSize().size() - 1);
//        Integer time = endTime - startTime;
//        Integer speed = chargerAOC.getChargerSpeed();
//        leftSize = leftSize + time*speed/60;
//        bigBus.getLeftSize().add(leftSize);
//    }
//    public void chargingHOCBigBus(BigBus bigBus,ChargerHOC chargerHOC, Integer startTime, Integer endTime){
//        Integer leftSize = bigBus.getLeftSize().get(bigBus.getLeftSize().size() - 1);
//        Integer time = endTime - startTime;
//        Integer speed = chargerHOC.getChargerSpeed();
//        leftSize = leftSize + time*speed/60;
//        bigBus.getLeftSize().add(leftSize);
//    }
//    public int getNextDepartureTime(Bus bus){
//        Integer endTime = bus.getEndTime().get(bus.getEndTime().size() - 1);
//        Integer leftSize = bus.getLeftSize().get(bus.getLeftSize().size() - 1);
//
//    }
}
