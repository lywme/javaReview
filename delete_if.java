import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        Node newList=createLinkedList(Arrays.asList(2,2,1,2,5));
        Node.print(newList);
        
        Node.print(delete_if(newList,2));

    }

    public static Node createLinkedList(List<Integer> inputlist)
    {
        Node listHead=null;
        Node prev=null;
        for(Integer item:inputlist)
        {
            Node newNode=new Node(item);
            if(prev!=null)
            {
                prev.setNext(newNode);
            }
            if(listHead==null)
            {
                listHead=newNode;
            }

            prev=newNode;
        }
        return listHead;
    }

    public static Node delete_if(Node head,int value)
    {
        Node curr=head;
        Node prev=null;
        //建立一个dummy head
        Node newHead=new Node(0);
        newHead.setNext(curr);
        prev=newHead;

        while(curr!=null)
        {
            if(curr.getValue()==value)
            {

                prev.setNext(curr.getNext());
            }
            else
            {
                prev=curr;

            }
            curr=curr.getNext();
        }

        //结果要跳过dummy head
        return newHead.getNext();
    }
}


class Node{
    private Node next;
    private int value;

    Node(int value){
        this.value=value;
        this.next=null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.value+" -> ");
            head=head.getNext();
        }
        System.out.println();
    }
}
