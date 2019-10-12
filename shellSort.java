package com.company;
import java.util.Arrays;
import java.util.Random;
//Implement an Array Structure
//Stable Sort vs Unstable Sort, shell sort is an unstable sort algorithm

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

		System.out.println("Before Shell Sort: "+Arrays.toString(array));
		shellSort(array);
		System.out.println("After Shell Sort : "+Arrays.toString(array));

	}

	public static void shellSort(int[] arr)
	{
		for(int gap=arr.length/2;gap>0;gap=gap/2)
		{
			for(int i=gap;i<arr.length;i++)
			{
				int currentItem=arr[i];
				int j=i;
				while(j>=gap && arr[j-gap]>currentItem)
				{
					arr[j]=arr[j-gap];
					j=j-gap;
				}
				arr[j]=currentItem;
			}
		}
	}
}

