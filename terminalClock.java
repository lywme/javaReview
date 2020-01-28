package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main (String[] args){
        /**
         *   Print system time every seconds
         */
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        Date currentDate;
        String time;

        while(true)
        {
            currentDate=new Date();
            time=sdf.format(currentDate);
            System.out.println(time);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

    }
}

