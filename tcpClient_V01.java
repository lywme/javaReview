package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {


        Socket socket = new Socket("localhost", 8088);


        OutputStream os=socket.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
        PrintWriter pw=new PrintWriter(osw,true);
        Scanner scan=new Scanner(System.in);
        String str;
        while(!((str=scan.nextLine()).equals("exit")))
        {
            pw.println(str);
        }
    }
}
