package com.company;

/**
 *  Tell if any combination of numbers in the given array(excluding the largest number) 
 *  can be added up to equal the largest number in the array
 */

public class Main{
	public static void main(String[] args)
	{
		int[] inputArray=new int[]{4,6,23,10,3};
		System.out.println(ArrayAddition(inputArray));
	}

	public static String ArrayAddition(int[] inputArray)
	{
		int maxN=inputArray[0];
		int sum=0;
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i]>maxN)
			{
				maxN = inputArray[i];
			}
			sum+=inputArray[i];
		}
		sum-=maxN;
		if(sum==maxN)
			return "True";
		else
			return "False";
	}
}

