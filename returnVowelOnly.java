package com.company;


public class Main {
	public static void main(String[] args) {
		//Write a method with a random string input, returns a String containing only vowels.

		String target="Udacity Course";

		System.out.println(returnVowelOnly(target));

		target="Hello World!";
		System.out.println(returnVowelOnly(target));
	}

	public static String returnVowelOnly(String input)
	{
		String vowel="aeiou";
		StringBuilder tar=new StringBuilder();
		for(int i=0;i<input.length();i++)
		{
			if(vowel.contains(Character.toString(input.charAt(i)).toLowerCase()))
			{
				tar.append(input.charAt(i));
			}

		}
		return tar.toString();
	}
}
