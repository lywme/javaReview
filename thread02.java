package com.company;

public class Main {
    public static void main (String[] args){
        /**
         *   Create two thread
         */
        Runnable r1=new Runnable1();
        Runnable r2=new Runnable2();

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();

    }
}

class Runnable1 implements Runnable
{
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("Thread 1 is running.");
    }
}


class Runnable2 implements Runnable
{
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("Thread 2 is running.");
    }
}
