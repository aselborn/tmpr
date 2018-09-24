package tmpr;

import org.codehaus.enunciate.json.JsonRootType;

@JsonRootType
public class TemperatureResponse {


    private String temperatureAsString;
    private String timePointAsString;
    private String humidityAsString;

    public String getHumidityAsString() {
        return humidityAsString;
    }

    public void setHumidityAsString(String humidityAsString) {
        this.humidityAsString = humidityAsString;
    }

    public String getTemperatureAsString() {
        return temperatureAsString;
    }

    public void setTemperatureAsString(String temperatureAsString) {
        this.temperatureAsString = temperatureAsString;
    }

    public String getTimePointAsString() {
        return timePointAsString;
    }

    public void setTimePointAsString(String timePointAsString) {
        this.timePointAsString = timePointAsString;
    }

}
