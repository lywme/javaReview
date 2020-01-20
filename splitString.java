package com.company;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        String str="123,456,789,012";
        String[] strA=str.split("[,]");
        for(int i=0;i<strA.length;i++)
        {
            System.out.println(strA[i]);
        }
    }
}

