package com.company;

public class Main {
    public static void main (String[] args){
        /**
         *   Create two thread
         */

        Thread1 tr1=new Thread1();
        Thread2 tr2=new Thread2();

        tr1.start();
        tr2.start();

    }
}

class Thread1 extends Thread
{
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("Thread 1 is running.");
    }
}


class Thread2 extends Thread
{
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("Thread 2 is running.");
    }
}
