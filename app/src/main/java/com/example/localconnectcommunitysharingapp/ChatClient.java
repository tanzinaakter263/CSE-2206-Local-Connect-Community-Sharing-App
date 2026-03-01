package com.example.localconnectcommunitysharingapp;
import java.io.PrintWriter;
import java.net.Socket;
public class ChatClient extends Thread{
    private final String message;

    public ChatClient(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("192.168.0.100", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}