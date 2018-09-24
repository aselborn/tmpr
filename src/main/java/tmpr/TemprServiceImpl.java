package tmpr;

import engine.TempFetcher;

public class TemprServiceImpl implements TemprService {
    @Override
    public PingResponse ping() {

        return new PingResponse("TemprService is up and running!");

    }

    @Override
    public TemperatureResponse currentTemperature() {

        /*
        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setTemperatureAsString("10.2");
        temperatureResponse.setTimePointAsString("2018-09-21 12:10:20");

        */
        TemperatureResponse response = TempFetcher.getInstance().fetchCommand();

        return response;

    }
}
