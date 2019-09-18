package com.company;
//Implement an Array Structure

import java.util.Arrays;

class MyArray
{
	private int cur;
	private int[] data;

	public MyArray(int length)
	{
		this.cur=0;
		data=new int[length];
	}

	public void push(int number)
	{
		if(cur<data.length)
		{
			data[cur] = number;
			cur++;
		}
		else
		{
			//需要扩容
			this.data= Arrays.copyOf(data,data.length+1);
			data[cur]=number;
			cur++;
		}
	}

	public int pop()
	{
		int temp;
		temp=data[--cur];
		data[cur]=0;
		return temp;
	}

	public void print()
	{
		for(int i=0;i<data.length;i++)
		{
			if(data[i]!=0)
				System.out.print(data[i]+" ");
		}
		System.out.println();
	}

	public void delete(int index)
	{
		if(index>=0 && index<data.length)
		{
			for(int i=index;i<data.length-1;i++)
			{
				data[i]=data[i+1];
			}
		}
	}
}
public class Main{
	public static void main(String[] args)
	{
		MyArray arr=new MyArray(10);
		for(int i=1;i<=20;i++)
			arr.push(i);
		arr.print();
		arr.pop();
		arr.pop();
		arr.pop();
		arr.pop();
		arr.print();
		arr.delete(3);
		arr.print();
	}
}
