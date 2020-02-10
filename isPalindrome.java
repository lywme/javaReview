package com.company;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;


public class Test{
    public static void main(String[] args)
    {
        /**
         * Use a stack to check if the given string is palindrome,ignore the punctuation and Case(Upper and lower)
         */
        String str1="I did, did I ?";
        String str2="Racecar";
        String str3="hello";

        System.out.println(str1+" is palindrome? "+isPalindrome(str1));
        System.out.println(str2+" is palindrome? "+isPalindrome(str2));
        System.out.println(str3+" is palindrome? "+isPalindrome(str3));
    }

    public static boolean isPalindrome(String input)
    {
        //Change all letters to lower case to make it easy
        input=input.toLowerCase();

        LinkedList<Character> tempList=new LinkedList<Character>();
        //get rid of punctuation and change all the letter to lower case
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)>='a'&&input.charAt(i)<='z' || input.charAt(i)>='A'&&input.charAt(i)<='Z')
                tempList.add(input.charAt(i));
        }

        //create a stack
        Deque<Character> stack=new LinkedList<Character>();
        //push half of the List items in stack
        int half=0;

        half=tempList.size()/2;

        for(int i=0;i<half;i++)
            stack.push(tempList.get(i));
        //pop out from list one by one and check with the rest of templist
        boolean flag=true;
        //When size is even, jump 1 item in the middle
        if(tempList.size()%2!=0)
            half=half+1;

        for(int i=half;i<tempList.size();i++)
        {
            Character tempChar = stack.pop();
            if(tempList.get(i)!=tempChar)
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
}

