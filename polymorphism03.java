package com.company;

import java.util.Scanner;
import java.util.Arrays;

//polymorphism

abstract class Person
{
	abstract void cut();
}

interface Teach
{
	abstract void teach();
}

interface Eat
{
	abstract void eat();
}

class Doctor extends Person implements Eat,Teach
{
	public void cut()
	{
		System.out.println("Do operation");
	}

	public void teach()
	{
		System.out.println("Teach other doctors");
	}

	public void eat()
	{
		System.out.println("Eat food");
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
		Eat p1=new Doctor();
		p1.eat();

		//强制类型转换，就是把之前向上造型的类型转换为原来的类型
		Doctor p2=(Doctor)p1;
		p2.cut();
		//因为p1是Doctor类型，所以可以强转回Doctor类型
		System.out.println(p1 instanceof Doctor);

    }
}
