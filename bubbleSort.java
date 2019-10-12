package com.company;
import java.util.Arrays;
import java.util.Random;
//Implement an Array Structure


public class Main{
	public static void main(String[] args)
	{
		//Initialize a random array to sort
		int[] array=new int[20];
		Random ran=new Random();
		for(int i=0;i<array.length;i++)
		{
			//assign each item a value range from 0~99
			array[i]=ran.nextInt(100);
		}

		System.out.println("Before Bubble Sort: "+Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After Bubble Sort : "+Arrays.toString(array));

	}

	public static void bubbleSort(int[] arr)
	{
		for(int lastUnsortedPart=arr.length-2;lastUnsortedPart>0;lastUnsortedPart--)
		{
			for(int j=0;j<=lastUnsortedPart;j++)
			{
				if(arr[j]>arr[j+1])
				{
					swapArray(arr,j,j+1);
				}
			}
		}
	}

	public static void swapArray(int[] arr,int i,int j)
	{
		if(i==j)
			return;
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

