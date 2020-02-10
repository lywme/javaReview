package com.company;
import java.util.Arrays;
import java.util.Random;


public class Test{
    public static void main(String[] args)
    {
        Random ran=new Random();
        MyList a=new MyList();
        for(int i=0;i<10;i++) {
            a.addItem(ran.nextInt(100));
        }
        a.printItems();


        a.size();
    }
}

class MyList
{
    Node first;

    int count;

    public void addItem(int value)
    {

        if(this.first==null)
        {
            this.first = new Node(value);
            this.count++;
        }
        else
        {
            //find a place to add
            Node current=first;
            Node previous=null;
            while(current!=null&&current.data<=value)
            {
                previous=current;
                current=current.next;
            }

            if(current!=null&&previous!=null)
            {
                previous.next=new Node(value,current);
                count++;
            }
            else if(current!=null&&previous==null)
            {
                this.first=new Node(value,current);
                count++;
            }
            else if(current==null&&previous!=null)
            {
                //add to the end;
                previous.next=new Node(value);
                count++;
            }
        }

    }

    public int deleteItem()
    {
        Node n=first;
        first=first.next;
        this.count--;
        return Integer.parseInt(n.toString());
    }

    public void printItems()
    {
        Node current=first;
        while(current!=null)
        {
            System.out.print(current+", ");
            current=current.next;
        }
        System.out.println();
    }

    public void size()
    {
        System.out.println("Size="+this.count);
    }
}

class Node
{
    Node next;
    int data;

    Node(int value)
    {
        this.data=value;
        this.next=null;
    }

    Node(int value,Node next)
    {
        this.data=value;
        this.next=next;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
