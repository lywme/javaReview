import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        combination(new ArrayList<>(),Arrays.asList(1,2,3,4),2);
    }


    public static void combination(List<Integer> selected,List<Integer> data,int n)
    {
        if(n==0)
        {
            //说明已经选完，输出已选择结果
            for(Integer i:selected)
            {
                System.out.print(i+" ");
            }
            System.out.println();

            return;
        }

        if(data.size()==0)
        {
            return;
        }

        //select first item
        selected.add(data.get(0));
        combination(selected,data.subList(1,data.size()),n-1);

        //don't select first item
        selected.remove(selected.size()-1);
        combination(selected,data.subList(1,data.size()),n);
    }
}
