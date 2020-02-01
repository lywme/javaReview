package com.company;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] intArray=new int[10];
        Random ran=new Random();

        for(int i=0;i<intArray.length;i++)
        {
            intArray[i]=ran.nextInt(100);
        }


        System.out.println("Before selection sort :"+Arrays.toString(intArray));
        quickSort(intArray,0,intArray.length);
        System.out.println("After selection sort :"+Arrays.toString(intArray));
    }

    public static void bubbleSort(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length-i-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        for(int i=array.length-1;i>=0;i--)
        {
            int maxIndex=0;
            for(int j=0;j<=i;j++)
            {
                if(array[j]>array[maxIndex])
                    maxIndex=j;
            }

            //swap the max item in the array to the last
            int temp=array[i];
            array[i]=array[maxIndex];
            array[maxIndex]=temp;
        }
    }

    public static void insertionSort(int[] array)
    {
        for(int firstUnsorted=1;firstUnsorted<array.length;firstUnsorted++)
        {
            int temp=array[firstUnsorted];

            int lastSorted;

            for(lastSorted=firstUnsorted-1;lastSorted>=0;lastSorted--)
            {
                if(temp<array[lastSorted])
                {
                    array[lastSorted+1]=array[lastSorted];
                }
                else
                {
                    break;
                }
            }

            array[lastSorted+1]=temp;
        }
    }

    public static void shellSort(int[] array)
    {
        for(int gap = array.length / 2;gap>0;gap=gap/2)
        {
            for (int firstUnsorted = gap; firstUnsorted < array.length; firstUnsorted++) {
                int temp = array[firstUnsorted];

                int lastSorted;

                for (lastSorted = firstUnsorted; lastSorted >= gap && array[lastSorted-gap]>temp; lastSorted=lastSorted-gap) {

                    array[lastSorted] = array[lastSorted-gap];

                }
                array[lastSorted] = temp;
            }

        }
    }

    public static void mergeSort(int[] array,int startIndex,int endIndex)
    {
        if(endIndex-startIndex<2)
            return;

        int mid=(endIndex+startIndex)/2;
        mergeSort(array,startIndex,mid);
        mergeSort(array,mid,endIndex);
        merge(array,startIndex,mid,endIndex);
    }

    public static void merge(int[] inputArray,int startIndex,int mid,int endIndex)
    {
        if(inputArray[mid-1]<inputArray[mid])
            return;

        int i=startIndex;
        int j=mid;
        int tempIndex=0;
        int[] tempArray=new int[endIndex-startIndex];

        while(i<mid&&j<endIndex)
        {
            tempArray[tempIndex++]=inputArray[i]<inputArray[j]?inputArray[i++]:inputArray[j++];
        }

        //copy the rest items in the left sub array to original array
        System.arraycopy(inputArray,i,inputArray,startIndex+tempIndex,mid-i);

        //copy the items in the tempArray back to the original array
        System.arraycopy(tempArray,0,inputArray,startIndex,tempIndex);
    }

    public static void quickSort(int[] inputArray,int startIndex,int endIndex)
    {
        if(endIndex-startIndex<2)
            return;

        int pivot=partition(inputArray,startIndex,endIndex);
        quickSort(inputArray,startIndex,pivot);
        quickSort(inputArray,pivot+1,endIndex);
    }

    public static int partition(int[] inputArray,int startIndex,int endIndex)
    {
        int pivot=inputArray[startIndex];
        int i=startIndex;
        int j=endIndex;

        while(i<j)
        {
            while(i<j&&inputArray[--j]>=pivot);
            inputArray[i]=inputArray[j];

            while(i<j&&inputArray[++i]<=pivot);
            inputArray[j]=inputArray[i];
        }
        inputArray[j]=pivot;
        return j;
    }
}
