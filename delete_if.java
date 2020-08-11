import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        Node newList=createLinkedList(Arrays.asList(1,2,3,2,5));
        Node.print(newList);
        delete_if(newList,2);
        Node.print(newList);

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

    public static void delete_if(Node head,int n)
    {
        Node curr=head;
        Node prev=null;
        //建立一个dummy head
        Node newHead=new Node(0);
        newHead.setNext(curr);

        while(curr!=null)
        {
            if(curr.getValue()==n)
            {
                prev.setNext(curr.getNext());
            }
            prev=curr;
            curr=curr.getNext();
        }

        //结果要跳过dummy head
        head=newHead.getNext();
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
