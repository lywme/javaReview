package com.company;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main (String[] args)
    {
        /**
         *  Java Generics
         */

        class Point<T>
        {
            private T x;
            private T y;

            Point(T x,T y)
            {
                this.x=x;
                this.y=y;
            }

            public void setX(T x) {
                this.x = x;
            }

            public void setY(T y) {
                this.y = y;
            }

            public T getX() {
                return x;
            }

            public T getY() {
                return y;
            }

            public String toString()
            {
                return "X="+x+", "+"Y="+y;
            }
        }

        // Test Generics
        Point<Integer> p1=new Point<Integer>(1,2);
        System.out.println(p1);

        Point<String> p2=new Point<String>("Canada","USA");
        p2.setY("China");
        System.out.println(p2);
    }
}

