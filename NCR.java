import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class scratch
{



    public static void main(String[] args)
    {

        int[] arr=new int[]{9,13,7,10,0,6};
        sortToRight2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //naive approach
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

    //linear time complexity
    public static void sortToRight2(int[] inputArr)
    {
        for(int i=inputArr.length-2;i>=0;i--)
        {
            inputArr[i]=Math.max(inputArr[i],inputArr[i+1]);
        }
    }
}


