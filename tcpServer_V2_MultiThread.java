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

        while(true)
        {
            Socket socket = server.accept();
            ClientHandler ch=new ClientHandler(socket);
            Thread thread=new Thread(ch);
            thread.start();
            System.out.println("A new client successfully establish connection...");
        }

    }
}

class ClientHandler implements Runnable
{
    private Socket socket;
    ClientHandler(Socket socket)
    {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String str;
            while ((str = br.readLine()) != null) {
                System.out.println("Client says :" + str);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
