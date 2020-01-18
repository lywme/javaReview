package com.company;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Please input text:");
        Scanner scan=new Scanner(System.in);
        String text=scan.nextLine();

        int begin=0;
        int end=text.length()-1;
        boolean flag=true;
        while(begin<end)
        {
            if(text.charAt(begin)!=text.charAt(end))
            {
                flag=false;
                break;
            }
            begin++;
            end--;
        }
        if(flag)
            System.out.println("This text is palindromic!");
        else
            System.out.println("This text is not palindromic!");
    }
}

