package com.mattanger.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class OAuthRedirectHandler implements Runnable {

    private Socket _clientSocket;

    public OAuthRedirectHandler(Socket clientSocket) {
        _clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try ( BufferedReader in = new BufferedReader(
                new InputStreamReader(_clientSocket.getInputStream()))) {
            // read what we get..
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace(); //todo: log error
        }

    }
}
