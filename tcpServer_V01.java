package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8088);

        System.out.println("Waiting for client...");
        Socket socket=server.accept();
        System.out.println("Client successfully establish connection...");

        InputStream is=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);

        String str;
        while((str=br.readLine())!=null)
        {
            System.out.println("Client says :"+str);
        }
    }
}
