package com.company;

import java.util.Scanner;
import java.util.Arrays;

class Parent
{
	public int a;
	public int b;
	public static int num=0;

	Parent(int a,int b)
	{
		this.a=a;
		this.b=b;
		num++;
	}
}


public class Main {
    public static void main(String[] args) {
		Parent ins1=new Parent(1,2);
		Parent ins2=new Parent(1,2);


		System.out.println(Parent.num);


    }
}
