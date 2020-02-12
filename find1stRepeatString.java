package com.company;


import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		/**
		 * Java Programming Exercise 1
		 * Task Description:
		 * Complete find the first duplicate character in a string.
		 *
		 * Complete the following method so given a string it returns the index of the first duplicated character
		 * or -1 if there are no duplicated characters.
		 *
		 * Example1: input: abcabc, return: 3
		 *
		 * Example2: input: abcd, return: -1
		 */
		System.out.println(findDuplicate("abcabc"));
		System.out.println(findDuplicate("abcd"));
	}

	public static int findDuplicate(String input)
	{
		//loop throuth every char in string to find if there is another same letter
		int findNextIndex=input.length();
		int i;
		for(i=0;i<input.length();i++)
		{
			findNextIndex=input.substring(i+1).indexOf(input.charAt(i));
			if(findNextIndex!=-1)
			{
				//System.out.println(i+","+findNextIndex);
				break;
			}
		}

		//Does not have repeat string
		if(findNextIndex==-1)
			return -1;

		//have repeat string, find it out
		int j=i;
		for(++j;j<=findNextIndex;j++)
		{
			//System.out.println(input.substring(i, j + 1));
			String subString=input.substring(i, j + 1);
			if(input.substring(findNextIndex).contains(subString));
				return input.indexOf(subString,findNextIndex);
		}
		return -1;
	}
}
