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
        if(inputlist.size()==0)
        {
            return null;
        }
        Node newNode=new Node(inputlist.get(0));
        Node listHead=createLinkedList(inputlist.subList(1,inputlist.size()));
        newNode.setNext(listHead);
        return newNode;
    }

    /**
     * Use recursive to reverse the Linked list
     * @param take a head node of a linked list
     * @return the head of the List in reverse order
     */
    public static Node reverseLinkedList(Node head)
    {
        //如果节点数为0
        if(head==null)
        {
            return null;
        }
        //如果节点数为1
        if(head.getNext()==null)
        {
            return head;
        }


        Node firstNode=head;
        Node restListReverse=reverseLinkedList(head.getNext());
        //把第2个节点的next设置为第1个节点
        head.getNext().setNext(firstNode);
        //把第1个节点的next设置为null
        firstNode.setNext(null);
        return restListReverse;
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
