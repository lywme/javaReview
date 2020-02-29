package com.company;
import java.util.*;


public class Test{
    public static void main(String[] args) throws Exception {

        MaxHeap h=new MaxHeap(10);
        h.add(80);
        h.add(75);
        h.add(60);
        h.add(68);
        h.add(55);
        h.add(40);
        h.add(52);
        h.add(67);
        h.print();
        h.delete(0);
        h.print();

    }
}

class MaxHeap
{
    private int[] heap;
    private int size;

    public MaxHeap(int size)
    {
        heap=new int[size];
        this.size=0;
    }

    public void add(int value) throws Exception {
        if(isFull())
            throw new Exception("Heap is full!");

        heap[size]=value;
        heapifyUp(size);
        size++;
    }

    public int delete(int index)
    {
        if(size==0)
            throw new IndexOutOfBoundsException("Heap is empty!");
        if(index>size-1||index<0)
            throw new IndexOutOfBoundsException("Delete out of bound!");

        int deleteValue=heap[index];
        heap[index]=heap[size-1];
        int parentValue=heap[getParent(index)];
        if(heap[index]<parentValue ||index==0)
        {
            hepifyDown(index,size-1);
        }
        else
        {
            heapifyUp(index);
        }
        heap[size-1]=0;
        size--;

        return deleteValue;
    }

    public void heapifyUp(int index)
    {
        int newValue=heap[index];
        while(index>0 && heap[getParent(index)]<newValue)
        {
            heap[index]=heap[getParent(index)];
            index=getParent(index);
        }
        heap[index]=newValue;
    }

    public void hepifyDown(int index,int lastHeapIndex)
    {
        if(index<0||index>heap.length)
            throw new IndexOutOfBoundsException("Out of bound");

        int swapIndex;


        while(index<=lastHeapIndex)
        {
            int leftChild=getChild(index,true);
            int rightChild=getChild(index,false);

            if(leftChild<=lastHeapIndex)
            {
                if(rightChild<=lastHeapIndex)
                {
                    //index has left and right children
                    swapIndex=heap[leftChild]>heap[rightChild]?leftChild:rightChild;
                }
                else
                {
                    //index only have left child
                    swapIndex=leftChild;
                }

                //determine whether to swap or not
                if(heap[index]<heap[swapIndex])
                {
                    //swap
                    int temp=heap[index];
                    heap[index]=heap[swapIndex];
                    heap[swapIndex]=temp;
                }
                else
                {
                    //does not need to swap
                    break;
                }
            }
            else {
                //does not have left and right child
                break;
            }
            //update index to its child, actually index=swapIndex
//            index=heap[getChild(index,true)]>heap[getChild(index,false)]?getChild(index,true):getChild(index,false);
            index=swapIndex;
        }
    }

    public int getChild(int index,boolean isLeft)
    {
        if(isLeft)
        {
            return 2*index+1;
        }
        else
        {
            return 2*index+2;
        }
    }

    public void print()
    {
        System.out.println(Arrays.toString(heap));
    }

    public boolean isFull()
    {
        return size==heap.length;
    }

    public int getParent(int index)
    {
        return (index-1)/2;
    }
}
