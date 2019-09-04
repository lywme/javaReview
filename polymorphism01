package com.company;

import java.util.Scanner;
import java.util.Arrays;

//polymorphism

abstract class Person
{
	abstract void cut();
}

class Doctor extends Person
{
	public void cut()
	{
		System.out.println("Do operation");
	}
}

class Actor extends Person
{
	public void cut()
	{
		System.out.println("Stop performance");
	}
}

class Barber extends Person
{
	public void cut()
	{
		System.out.println("Do haircut");
	}

	public void other()
	{}
}

public class Main {
    public static void main(String[] args) {
		Person p1=new Doctor();
		Person p2=new Actor();
		Person p3=new Barber();

		p1.cut();
		p2.cut();
		p3.cut();


    }
}
