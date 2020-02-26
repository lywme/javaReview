import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        /**
         *   ABCBBAAD
         *   Suppose each letter in the given string is a book
         *   You can only hold 1 kind of book in one hand
         *   How many books you can hold the most with both your hands?
         */
        String input="ABCBBAAD";
        for(int i=0;i<input.length();i++)
        {
            int[] arrL=findBEsameL(input, i);
//            System.out.println(arrL[0]+", "+arrL[1]);
//            System.out.println(input.substring(arrL[0],arrL[1]+1));
            int[] arrR=findBEsameL(input, arrL[1]+1);
            System.out.println(input.substring(arrL[0],arrR[1]+1));
            i=arrL[1];
        }

        System.out.println("The most books with two hands are: "+mostTwohands(input));

    }


    public static String mostTwohands(String input)
    {
        String r="";
        for(int i=0;i<input.length();i++)
        {
            int[] arrL=findBEsameL(input, i);
            int[] arrR=findBEsameL(input, arrL[1]+1);
            if((arrR[1]-arrL[0])>r.length())
                r=new String(input.substring(arrL[0],arrR[1]+1));
            i=arrL[1];
        }
        return r;
    }

    public static int[] findBEsameL(String input,int s)
    {
        for(int i=s;i<input.length();i++)
        {
            if(input.charAt(i)==input.charAt(s))
            {
                continue;
            }
            else
            {
                int[] r=new int[]{s,i-1};
                return r;
            }
        }
        int[] r=new int[]{s,input.length()-1};
        return r;
    }
}

