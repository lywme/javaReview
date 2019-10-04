package com.company;
//Implement an Array Structure


public class Main{
	public static void main(String[] args)
	{
		Point p1=new Point(2,3);
		Point p2=new Point(2,3);

		System.out.println(p1);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
}

class Point
{
	private int x;
	private int y;

	public Point(int x,int y)
	{
		this.set(x,y);
	}

	public void set(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String toString()
	{
		return "("+String.valueOf(x)+" "+String.valueOf(y)+")";
	}

	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		if(obj==this)
			return false;
		if(obj instanceof Point)
		{
			Point temP=(Point) obj;
			return this.x==temP.x && this.y== temP.y;
		}
		return false;
	}
}
