import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        Node newList=createLinkedList(Arrays.asList(1,2,3,4,5));
        Node.print(newList);
        newList=reverseLinkedList(newList);
        Node.print(newList);


        newList=createLinkedList(Arrays.asList(1));
        Node.print(newList);
        newList=reverseLinkedList(newList);
        Node.print(newList);
    }

    public static Node createLinkedList(List<Integer> inputlist)
    {
        Node listHead=null;

        for(Integer item:inputlist)
        {
            Node newNode=new Node(item);
            newNode.setNext(listHead);
            listHead=newNode;
        }
        return listHead;
    }

    /**
     * Use reverse the Linked list using loop
     * @param take a head node of a linked list
     * @return the head of the List in reverse order
     */
    public static Node reverseLinkedList(Node head)
    {
        Node newHead=null;
        Node currentHead=head;
        while(currentHead!=null)
        {
            Node next=currentHead.getNext();
            currentHead.setNext(newHead);
            newHead=currentHead;
            currentHead=next;
        }

        return newHead;
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
