package com.tecnara.weather.client;

import com.google.gson.Gson;
import com.tecnara.weather.client.dominio.ServerResponse;
import com.tecnara.weather.client.utils.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);
        System.out.println("Give me the latitude");
        float lat= sc.nextFloat();
        System.out.println("Give me the length");
        float lon= sc.nextFloat();
        String coordinates= "{\"lon\":"+ lon + ", \"lat\":" + lat + "}";
        DataOutputStream dos = null;
        DataInputStream dis = null;
        Socket socket = null;
        try{
            socket= new Socket("localhost",3334);

            dos= new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(coordinates);

            dis= new DataInputStream(socket.getInputStream());
            String response = dis.readUTF();
            ServerResponse serverResponse = new Gson().fromJson(response,ServerResponse.class);
            String message = Utils.generateWeatherMessage(serverResponse);
            System.out.println(message);


        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(dos != null){
                dos.close();
            }
            if(dis != null){
                dis.close();
            }
            if(socket != null){
                socket.close();
            }



        }



    }
}
