package com.xcz.mybase.test.bean;

/**
 * desc:
 * Created by xcz
 * on 2018/7/9.
 */
public class SkBean {
    /**
     * temp : 34
     * wind_direction : 东南风
     * wind_strength : 4级
     * humidity : 40%
     * time : 17:34
     */

    private String temp;
    private String wind_direction;
    private String wind_strength;
    private String humidity;
    private String time;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_strength() {
        return wind_strength;
    }

    public void setWind_strength(String wind_strength) {
        this.wind_strength = wind_strength;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
