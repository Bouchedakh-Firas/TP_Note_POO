package model;

import java.util.Date;

public class Forecast{
        private String day;
    private String datetime;

    private String wind;


    private String weather;

    private String tmax;

    public String getTmax() {
        return tmax;
    }

    public void setTmax(String tmax) {
        this.tmax = tmax;
    }

    public Forecast() {
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "day=" + day +
                ", datetime='" + datetime + '\'' +
                ", wind=" + wind +
                ", weather=" + weather +
                '}';
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}



