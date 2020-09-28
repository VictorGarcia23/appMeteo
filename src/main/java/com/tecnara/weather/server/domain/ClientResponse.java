package com.tecnara.weather.server.domain;

public class ClientResponse {
    private String location;
    private String weather;
    private String weatherDescription;
    private float humidity;
    private Double temp;

    public ClientResponse(OpenWeatherResponse openWeatherResponse){
        this.location = openWeatherResponse.getName();
        this.weather = openWeatherResponse.getWeather().get(0).getMain();
        this.weatherDescription = openWeatherResponse.getWeather().get(0).getDescription();
        this.humidity = openWeatherResponse.getMain().getHumidity();
        this.temp = openWeatherResponse.getMain().getTemp();
    }
    public String getLocation() {
        return location;
    }

    public String getWeather() {
        return weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public float getHumidity() {
        return humidity;
    }

    public Double getTemp() {
        return temp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

}
