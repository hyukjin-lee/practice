package com.hyukk.practice.demo.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public void serve() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        if (line.isEmpty()) {
                            break;
                        }
                    }

                    final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    writer.write("HTTP/1 200 OK\r\n");
                    writer.write("\r\n");
                    writer.write("<Html><Head></Head><Body>Hi ToyServer</Body></Html>");

                    writer.flush();
                    reader.close();
                    writer.close();
                }
            }
        }
    }
}