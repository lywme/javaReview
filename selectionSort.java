package com.company;
import java.util.Arrays;
import java.util.Random;
//Implement an Array Structure
//Stable Sort vs Unstable Sort, Selection sort is an unstable sort algorithm

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

		System.out.println("Before Selection Sort: "+Arrays.toString(array));
		selectionSort(array);
		System.out.println("After Selection Sort : "+Arrays.toString(array));

	}

	public static void selectionSort(int[] arr)
	{
		for(int lastUnsortedPart=arr.length-1;lastUnsortedPart>0;lastUnsortedPart--)
		{
			int maxIndex=0;
			for(int i=1;i<=lastUnsortedPart;i++)
			{
				if(arr[i]>arr[maxIndex])
					maxIndex=i;
			}
			swapArray(arr,lastUnsortedPart,maxIndex);
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

