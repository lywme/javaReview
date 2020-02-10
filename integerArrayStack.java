package com.company;
import java.util.Arrays;
import java.util.Random;


public class Test{
    public static void main(String[] args)
    {
        Random ran=new Random();
        MyStack s=new MyStack();
        for(int i=0;i<10;i++) {
            s.push(ran.nextInt(100));
        }

        s.printStack();
        int t;
        while((t=s.pop())!=-1)
        {
            System.out.println("poped :"+ Integer.toString(t));
        }


    }
}

class MyStack
{
    int[] data;
    int topIndex;

    MyStack()
    {
        data=new int[10];
        topIndex=-1;
    }

    public void push(int value)
    {
        if(topIndex==data.length-1)
        {
            grow();
        }

        data[++topIndex]=value;
    }

    public int pop()
    {
        if(topIndex>=0)
            return data[topIndex--];
        else
            return -1;
    }

    public int peek()
    {
        return data[topIndex];
    }

    public void grow()
    {
        //grop 10 more space
        data=Arrays.copyOf(data,data.length+10);
    }

    public void printStack()
    {
        System.out.print("Items in stack :");
        for(int i=topIndex;i>=0;i--)
        {
            System.out.print(data[i]+" -> ");
        }
        System.out.println("End of Stack");
    }
}
