package com.example.localconnectcommunitysharingapp;
import java.io.*;
import java.net.*;
public class ServerCode {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket client = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = in.readLine();
            System.out.println("Message received: " + msg);
            client.close();
        }
    }
}

