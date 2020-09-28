package com.tecnara.weather.server;

import com.google.gson.Gson;
import com.tecnara.weather.server.domain.ClientResponse;
import com.tecnara.weather.server.domain.Coordinates;
import com.tecnara.weather.server.domain.OpenWeatherResponse;
import com.tecnara.weather.server.services.meteo.OpenWeatherService;
import com.tecnara.weather.server.utils.Checker;
import com.tecnara.weather.server.utils.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3334);

        try {


            while (true) {
                System.out.println("Listening...");
                Socket socket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String coordinatesMsg = dis.readUTF();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                if (Checker.checkFormat(coordinatesMsg)) {
                    Coordinates coordinates = Utils.parseCoordinates(coordinatesMsg);
                    OpenWeatherService openWeatherService = new OpenWeatherService();
                    OpenWeatherResponse response = openWeatherService.getCurrentWeather(coordinates);
                    ClientResponse clientResponse = new ClientResponse(response);
                    dos.writeUTF(new Gson().toJson(clientResponse));

                    if (Checker.checkRange(coordinates)) {
                        //TODO delvoler

                    } else {
                        dos.writeUTF("The range isn't correct.");
                    }

                } else {
                    dos.writeUTF("The sintax isn't correct, write numbers.");
                }

                if (dos != null) {
                    dos.close();
                }
                if (dis != null) {
                    dis.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

