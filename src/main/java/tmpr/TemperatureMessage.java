package tmpr;

public abstract class TemperatureMessage {

    private String temperatureAsString;
    private String timePointAsString;

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
