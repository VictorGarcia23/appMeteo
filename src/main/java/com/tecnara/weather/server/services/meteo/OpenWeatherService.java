package com.tecnara.weather.server.services.meteo;


import com.google.gson.Gson;
import com.tecnara.weather.server.domain.Coordinates;
import com.tecnara.weather.server.domain.OpenWeatherResponse;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class OpenWeatherService {

    final String url= "http://api.openweathermap.org/data/2.5/weather?lat=35.3&lon=139&appid=" +
                      "3e2d658a45d141292b9ac778c8b2dc32";

    public static OpenWeatherResponse getCurrentWeather(Coordinates coordinates) {

        String urlApi= "http://api.openweathermap.org/data/2.5/weather?lat=" + coordinates.getLat() +
                        "&lon=" + coordinates.getLon() + "&appid=3e2d658a45d141292b9ac778c8b2dc32";
        try{
            URL url = new URL(urlApi);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }
            bufferedReader.close();
            String jsonContent = content.toString();
            Gson gson = new Gson();
            OpenWeatherResponse openinfo = gson.fromJson(jsonContent, OpenWeatherResponse.class);
            return openinfo;



        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


}
