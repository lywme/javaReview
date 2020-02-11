package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		/*
		Please complete the coding exercise for List.

Give a list of strings, all in lowercase, and all start with an alphabet character, please group them based on their first character. If the first character is a, group them in a list 0. If the first character is ‘b’, group them in a list 1; other characters, group them in a list 2.

Example1 : input: {“bcd”, “abc”, “cde”}, output: [{“abc”}, {“bcd”}, {“cde”}]

Example2: Input: List: {“abc”, “bcd”, “bbb”, “ace”, “snb”, “aaaa”, “bbbbb”, “eeee”}
Output: [{“abc”, “ace”, “aaaa”}, {“bcd”, “bbb”, “bbbb”}, {“snb”, “eeee”}]
		 */
		List<String> input=new LinkedList<String>();
		input.add("abc");
		input.add("bcd");
		input.add("bbb");
		input.add("ace");
		input.add("snb");
		input.add("aaaa");
		input.add("bbbbb");
		input.add("eeee");

		System.out.println(groupString(input));
	}

	public static List<String> groupString(List<String> input) {
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		List<String> returnList=new LinkedList<String>();

		for(int j=0;j<alphabet.length();j++) {
			List<String> tempList=new LinkedList<String>();
			for (int i = 0; i < input.size(); i++) {
				String str = input.get(i);
				if(str.startsWith(Character.toString(alphabet.charAt(j)).toLowerCase()))
				{
					tempList.add(str);
				}
			}
			if(tempList.size()!=0)
				returnList.add(tempList.toString());
		}
		return returnList;
	}
}
