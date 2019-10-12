package com.company;
import java.util.Arrays;
import java.util.Random;
//Implement an Array Structure
//Stable Sort vs Unstable Sort, insertion sort is a stable sort algorithm

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

		System.out.println("Before Insertion Sort: "+Arrays.toString(array));
		insertionSort(array);
		System.out.println("After Insertion Sort : "+Arrays.toString(array));

	}

	public static void insertionSort(int[] arr)
	{
		for(int firstUnsortedIndex=1;firstUnsortedIndex<arr.length;firstUnsortedIndex++)
		{
			int currentItem=arr[firstUnsortedIndex];
			int i=firstUnsortedIndex;
			for(;i>0&&arr[i-1]>currentItem;i--)
			{
				arr[i]=arr[i-1];
			}
			arr[i]=currentItem;
		}
	}
}

