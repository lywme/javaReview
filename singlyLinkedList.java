package com.company;



public class Main{
	public static void main(String[] args)
	{
		singlyLinkedListHead sl=new singlyLinkedListHead();
		System.out.println(sl.isEmpty());
		sl.addInFront("China");
		sl.addInFront("Canada");
		System.out.println(sl.size());
		sl.printAllNode();
		sl.addInFront("USA");
		System.out.println(sl.size());
		sl.printAllNode();

		System.out.println(sl.removeFromFront().getName());
		sl.printAllNode();
		System.out.println(sl.size());
		System.out.println(sl.isEmpty());
	}
}

class singlyLinkedListHead
{
	private int count=0;
	singlyLinkedListNode head;

	void addInFront(String name)
	{
		singlyLinkedListNode newNode=new singlyLinkedListNode(name);
		newNode.setNext(head);
		head=newNode;
		count++;
	}

	boolean isEmpty()
	{
		return head==null;
	}

	singlyLinkedListNode removeFromFront()
	{
		if(isEmpty())
			return null;
		singlyLinkedListNode temp=head;
		head=head.getNext();
		count--;
		return temp;
	}

	int size()
	{
		return count;
	}
	void printAllNode()
	{
		System.out.print("Head :");
		singlyLinkedListNode current=head;
		while(current!=null)
		{
			System.out.print(" --> "+current.getName());
			current=current.getNext();
		}
		System.out.println("-> Null");
	}
}

class singlyLinkedListNode
{
	private String Name;
	private singlyLinkedListNode next;

	singlyLinkedListNode(String name)
	{
		this.Name=name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public singlyLinkedListNode getNext() {
		return next;
	}

	public void setNext(singlyLinkedListNode next) {
		this.next = next;
	}
}
