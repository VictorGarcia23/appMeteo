package com.tecnara.weather.client.utils;

import com.tecnara.weather.client.dominio.ServerResponse;
import com.tecnara.weather.server.Server;
import com.tecnara.weather.server.domain.ClientResponse;

public class Utils {
    public static String generateWeatherMessage(ServerResponse serverResponse){
        StringBuilder sb = new StringBuilder();
        sb.append(serverResponse.getHumidity());
        sb.append(serverResponse.getLocation());
        sb.append(serverResponse.getTemp());
        sb.append(serverResponse.getWeather());
        sb.append(serverResponse.getWeatherDescription());

        return sb.toString();
    }
}
