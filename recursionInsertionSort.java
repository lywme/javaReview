package com.company;
import java.util.Arrays;
import java.util.Random;


public class Test{
    public static void main(String[] args)
    {
        //Initialize a random array to sort
        int[] array=new int[5];
        Random ran=new Random();
        for(int i=0;i<array.length;i++)
        {
            //assign each item a value range from 0~99
            array[i]=ran.nextInt(100);
        }

        System.out.println("Before Insertion Sort: "+Arrays.toString(array));
        insertionSort(array,array.length);
        System.out.println("After Insertion Sort : "+Arrays.toString(array));

    }

    public static void insertionSort(int[] array,int numberOfItems)
    {
        if(numberOfItems<2)
            return;

        insertionSort(array, numberOfItems-1);
        //once return from last line, num-1 items are sorted

        //so we try to find a place to insert the last unsorted item
        int tempNum=array[numberOfItems-1];
        int i=numberOfItems-1;
        for(;i>0&&tempNum<array[i-1];i--)
        {
            array[i]=array[i-1];
        }
        array[i]=tempNum;
    }


}
