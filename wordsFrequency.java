package com.company;


import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
	/**
	 *Please complete the “words frequency” coding problem.
	 *
	 * Give a list of strings, calculate and print the frequency of each string based on alphabetical order.
	 *
	 * Example1: input {“abc”, “bcd”, “abc”}, output “abc”|2, “bcd”|1
	 */
		LinkedList<String> list=new LinkedList<String>();
		list.add("abc");
		list.add("bcd");
		list.add("abc");
		//System.out.println(list);
		frequent(list);
	}

	public static void frequent(List<String> list)
	{
		//use TreeMap because need to keep the alphabetical order
		Map<String,Integer> map=new TreeMap<String,Integer>();
		Iterator iter=list.iterator();
		while(iter.hasNext())
		{
			String str=iter.next().toString();
			if(!map.containsKey(str))
				map.put(str,1);
			else
			{
				int value=map.get(str);
				map.put(str,++value);
			}
		}

		Set<Entry<String,Integer>> entrySet=map.entrySet();
		for(Entry<String,Integer> e:entrySet)
		{
			String key=e.getKey();
			int count=e.getValue();
			System.out.print("\""+key+"\"|"+count+", ");
		}
		System.out.println();
	}
}
