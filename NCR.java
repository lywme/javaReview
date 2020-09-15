import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class scratch
{

    /*
    Question:

    Given an arry of integers that is not sorted, find the maximum number to the right (the same or higher index) of each integer in the array.
    
    E.g.
    
    Input:
    [ 9,  13,  7, 10, 0, 6 ]
    
    Output:
    
    [ 13, 13, 10, 10, 6, 6 ]
     */
    
    public static void main(String[] args)
    {

        int[] arr=new int[]{9,13,7,10,0,6};
        sortToRight(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortToRight(int[] inputArr)
    {
        for(int i=inputArr.length-1;i>=0;i--)
        {
            int maxInt=Integer.MIN_VALUE;
            int j=i;
            for(;j<inputArr.length;j++)
            {
                if(inputArr[j]>maxInt)
                {
                    maxInt=inputArr[j];
                }
            }
            inputArr[i]=maxInt;
        }
    }
}


