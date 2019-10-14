package com.company;
import java.util.Arrays;
import java.util.Random;


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

		System.out.println("Before Quick Sort: "+Arrays.toString(array));
		quickSort(array,0,array.length);
		System.out.println("After Quick Sort : "+Arrays.toString(array));

	}

	public static void quickSort(int[] array,int startIndex, int endIndex)
	{
		if(endIndex-startIndex<2)
			return;
		int pivotIndex=partition(array,startIndex,endIndex);
		quickSort(array,startIndex,pivotIndex);
		quickSort(array,pivotIndex+1,endIndex);
	}

	public static int partition(int[] array,int startIndex,int endIndex)
	{
		//choose the first element as pivot
		int pivot=array[startIndex];
		int i=startIndex;
		int j=endIndex;

		while(i<j)
		{
			//this is an EMPTY while loop
			while(i<j&&array[--j]>=pivot);
			if(i<j)
				array[i]=array[j];
			while(i<j&&array[++i]<=pivot);
			if(i<j)
				array[j]=array[i];
		}
		array[j]=pivot;
		return j;
	}
}

