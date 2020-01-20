package com.company;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        /**
         *  User input the date he was given birth with format (1992-07-13)
         *  Calculate how many days this user lives on earth
         */

        System.out.println("Please input the date you was given birth (eg. 1992-07-13) :");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();

        if(input.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}"))
        {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date dateBirth=sdf.parse(input);
            Date currentTime=new Date();
            long timeDifference=currentTime.getTime()-dateBirth.getTime();
            long days=timeDifference/(1000*60*60*24);
            System.out.println("You have lived "+days+" days.");
        }
        else
        {
            System.out.println("Invalid input date.");
        }
    }
}

