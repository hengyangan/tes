package com.inse.tes.service;

public interface BusService {

    public void chargerABusSmallService(Integer modelAOCInput, Integer modelAONInput, Integer smallBusInput);

    public void chargerABusBigService(Integer modelAOCInput, Integer modelAONInput, Integer bigBusInput);

    public void chargerHBusSmallService(Integer modelHOCInput, Integer modelHONInput, Integer smallBusInput);

    public void chargerHBusBigService(Integer modelHOCInput, Integer modelHONInput, Integer bigBusInput);

}
