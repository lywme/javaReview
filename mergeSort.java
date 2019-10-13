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

		System.out.println("Before Merge Sort: "+Arrays.toString(array));
		mergeSort(array,0,array.length);
		System.out.println("After Merge Sort : "+Arrays.toString(array));

	}

	public static void mergeSort(int[] array,int startIndex, int endIndex)
	{
		if(endIndex-startIndex<2)
			return;
		int mid=(endIndex+startIndex)/2;
		mergeSort(array,startIndex,mid);
		mergeSort(array,mid,endIndex);
		merge(array,startIndex,mid,endIndex);
	}

	public static void merge(int[] array,int startIndex,int mid,int endIndex)
	{
		if(array[mid-1]<=array[mid])
			return;

		int i=startIndex;
		int j=mid;
		int tempIndex=0;
		int[] tempArray=new int[endIndex-startIndex];
		while(i<mid&&j<endIndex)
		{
			tempArray[tempIndex++]=array[i]<=array[j]?array[i++]:array[j++];
		}
		//copy any elements left in the left array
		System.arraycopy(array,i,array,startIndex+tempIndex,mid-i);
		//copy the auxiliary array back to original array
		System.arraycopy(tempArray,0,array,startIndex,tempIndex);
	}
}

