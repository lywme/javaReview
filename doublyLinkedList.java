package com.company;



public class Main{
	public static void main(String[] args)
	{
		doublyLinkedListHead dl=new doublyLinkedListHead();
		System.out.println(dl.isEmpty());
		dl.addInFront("China");
		dl.addInFront("Canada");
		System.out.println(dl.size());
		dl.printAllFromFront();
		dl.addInFront("USA");
		System.out.println(dl.size());
		dl.printAllFromFront();

		System.out.println(dl.removeFromFront().getName());
		dl.printAllFromFront();
		System.out.println(dl.size());
		System.out.println(dl.isEmpty());
		dl.printAllFromEnd();

		dl.addIntheEnd("Japan");
		dl.addIntheEnd("Korea");
		dl.printAllFromFront();
		dl.printAllFromEnd();
		System.out.println(dl.size());
		dl.removeFromEnd();
		dl.printAllFromFront();
		dl.printAllFromEnd();
		System.out.println(dl.size());

		dl.addAfterName("Canada","Brazil");
		dl.printAllFromFront();
		dl.printAllFromEnd();
		System.out.println(dl.size());
		dl.addAfterName("Brazil","New Zealand");
		dl.printAllFromFront();
		dl.printAllFromEnd();
		System.out.println(dl.size());
	}
}

class doublyLinkedListHead
{
	private int count=0;
	doublyLinkedListNode head;
	doublyLinkedListNode tail;

	void addInFront(String name)
	{
		doublyLinkedListNode newNode=new doublyLinkedListNode(name);
		if(head==null)
		{
			//add the 1st item in list
			newNode.setPrevious(null);
			newNode.setNext(null);
			head=newNode;
			tail=newNode;
		}
		else
		{
			head.setPrevious(newNode);
			newNode.setNext(head);
			head=newNode;
			newNode.setPrevious(null);

		}
		count++;
	}

	void addIntheEnd(String name)
	{
		doublyLinkedListNode newNode=new doublyLinkedListNode(name);
		if(head==null)
		{
			//The same as add the 1st item in list
			newNode.setPrevious(null);
			newNode.setNext(null);
			head=newNode;
			tail=newNode;
		}
		else
		{
			newNode.setPrevious(tail);
			newNode.setNext(null);
			tail.setNext(newNode);
			tail=newNode;

		}
		count++;
	}

	void addAfterName(String name,String newStringName)
	{
		doublyLinkedListNode current=head;
		while(current!=null)
		{
			if(current.getName().equals(name))
				break;
			current=current.getNext();
		}
		System.out.println("Quit");
		System.out.println(current!=null);
		if(current!=null)
		{
			//found item
			doublyLinkedListNode newNode=new doublyLinkedListNode(newStringName);

			current.getNext().setPrevious(newNode);
			newNode.setNext(current.getNext());
			newNode.setPrevious(current);
			current.setNext(newNode);
			count++;
		}
	}

	boolean isEmpty()
	{
		return head==null;
	}

	doublyLinkedListNode removeFromFront()
	{
		if(isEmpty())
			return null;
		doublyLinkedListNode temp=head;
		head=head.getNext();
		head.setPrevious(null);
		count--;
		return temp;
	}

	doublyLinkedListNode removeFromEnd()
	{
		if(isEmpty())
			return null;
		doublyLinkedListNode temp=tail;
		tail.getPrevious().setNext(null);
		tail=tail.getPrevious();
		count--;
		return temp;
	}

	int size()
	{
		return count;
	}
	void printAllFromFront()
	{
		System.out.print("Head :");
		doublyLinkedListNode current=head;
		while(current!=null)
		{
			System.out.print(" --> "+current.getName());
			current=current.getNext();
		}
		System.out.println("-> Tail");
	}

	void printAllFromEnd()
	{
		System.out.print("Tail :");
		doublyLinkedListNode current=tail;
		while(current!=null)
		{
			System.out.print(" --> "+current.getName());
			current=current.getPrevious();
		}
		System.out.println("-> Head");
	}
}

class doublyLinkedListNode
{
	private String Name;
	private doublyLinkedListNode previous;
	private doublyLinkedListNode next;

	doublyLinkedListNode(String name)
	{
		this.Name=name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public doublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(doublyLinkedListNode next) {
		this.next = next;
	}

	public doublyLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(doublyLinkedListNode previous) {
		this.previous = previous;
	}
}
