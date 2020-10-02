import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class scratch
{

    public static void main(String[] args)
    {
        System.out.println(getEncryptedName("Kate Winslet"));
    }

    public static boolean validate(String name)
    {
        return true;
    }


    public static String getEncryptedName(String name)
    {
        StringBuilder sb=new StringBuilder();
        if(validate(name))
        {
            char[] charArr=name.toCharArray();
            for(int i=0;i<name.length();i++)
            {
                if(charArr[i]>='A' && charArr[i]<='Z')
                {
                    charArr[i]=Character.toLowerCase(charArr[i]);
                }
            }

            for(int i=name.length()-1;i>=0;i--)
            {
                sb.append(charArr[i]);
            }

            return sb.toString();
        }
        else
        {
            throw new IllegalArgumentException("Try again with valid name");
        }
    }

}


