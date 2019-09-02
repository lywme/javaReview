package com.company;

import java.util.Scanner;
import java.util.Arrays;

class Parent
{
	int a;
	int b;

	Parent(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
}

class Son extends Parent
{
	int c;

	Son(int a,int b,int c)
	{
		super(a,b);
		this.c=c;
	}
}

public class Main {
    public static void main(String[] args) {
		Parent ins=new Son(1,2,3);

		System.out.println(ins.a);
		System.out.println(ins.b);

		//Error - Use reference of Parent can only access what's declared in Parent
		//System.out.println(ins.c);

    }
}
