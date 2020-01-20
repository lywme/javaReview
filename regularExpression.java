package com.company;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Please input a number:");
        Scanner scan=new Scanner(System.in);
        String text=scan.nextLine();

        if(text.matches("[\\d]+"))
        {
            System.out.println("The input number is an Integer");
        }else if(text.matches("[\\d]+\\.[\\d]+"))
        {
            System.out.println("The input number is a Decimal");
        }else
        {
            System.out.println("Input number is not a number");
        }
    }
}

