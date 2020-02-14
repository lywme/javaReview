package com.company;
import java.util.*;


public class Test{
    public static void main(String[] args) {
        /**
         * implement a binary search tree
         */

        BinarySearchTree btree=new BinarySearchTree();
//        btree.add(25);
//        btree.add(20);
//        btree.add(15);
//        btree.add(27);
//        btree.add(30);
//        btree.add(29);
//        btree.add(26);
//        btree.add(22);
//        btree.add(32);
//        btree.inOrderTraversal();
//        System.out.println(btree.get(26));
//        System.out.println("max value is: "+btree.max());
//        System.out.println("min value is: "+btree.min());

        btree.add(10);
        btree.add(20);
        btree.add(15);
        btree.add(3);
        btree.inOrderTraversal();
        btree.delete(15);
        btree.inOrderTraversal();
    }
}

class BinarySearchTree
{
    private BinarySearchTreeNode root;

    public void add(int value)
    {
        if(root==null)
            root=new BinarySearchTreeNode(value);
        else
            root.add(value);
    }

    public boolean delete(int value)
    {
        BinarySearchTreeNode current=root;
        BinarySearchTreeNode parent=null;
        Boolean isLeftChild=true;

        while(current.getData()!=value)
        {
            parent=current;
            if(current.getData()>value)
            {
                //go to its left subtree
                current=current.getLeftNode();
                isLeftChild=true;
            }
            else
            {
                //go to its right subtree
                current=current.getRightNode();
                isLeftChild=false;
            }

            if(current==null)
                return false;
        }

        //found the node is stored in current reference

        //Case 1: if the node does not have any child
        if(current.getLeftNode()==null&&current.getRightNode()==null)
        {
            if(current==root)
                root=null;
            else if(isLeftChild)
                parent.setLeftNode(null);
            else
                parent.setRightNode(null);
        }else if(current.getLeftNode()==null)  //Case 2: the node only have one right child
        {
            if(current==root)
                root=current.getRightNode();
            else if(isLeftChild)
                parent.setLeftNode(current.getRightNode());
            else
                parent.setRightNode(current.getRightNode());
        }else if(current.getRightNode()==null)  //Case 2: the node only have one left child
        {
            if(current==root)
                root=current.getLeftNode();
            else if(isLeftChild)
                parent.setLeftNode(current.getLeftNode());
            else
                parent.setRightNode(current.getLeftNode());
        }else                                   //Case 3: the node has both left child and right child
        {
            BinarySearchTreeNode successor=getSuccessor(current);
            if(current==root)
                root=successor;
            else if(isLeftChild)
            {
                parent.setLeftNode(successor);
            }
            else
            {
                parent.setRightNode(successor);
            }

            //set sueeessor's left child
            successor.setLeftNode(current.getLeftNode());
        }

        return true;

    }

    private BinarySearchTreeNode getSuccessor(BinarySearchTreeNode deleteNode)
    {
        //auxiliary method to find a node's successor
        BinarySearchTreeNode current=deleteNode.getRightNode();
        BinarySearchTreeNode successor=deleteNode;
        BinarySearchTreeNode successorParent=deleteNode;

        while(current!=null)
        {
            successorParent=successor;
            successor=current;
            current=current.getLeftNode();
        }

        if(successor!=deleteNode.getRightNode())
        {
            successorParent.setLeftNode(successor.getRightNode());  //successor parent equals null or successor's right child
            successor.setRightNode(deleteNode.getRightNode());    //Set successor's right child to the right child it should be
        }

        return successor;
    }


    public void inOrderTraversal()
    {
        if(root!=null)
            root.inOrderTraversal();
        System.out.println();
    }

    public BinarySearchTreeNode get(int value)
    {
        if(root==null)
            return null;
        else
            return root.get(value);
    }

    public int min()
    {
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return root.min();
    }

    public int max()
    {
        if(root==null)
            return Integer.MAX_VALUE;
        else
            return root.max();
    }
}

class BinarySearchTreeNode
{
    private int data;
    private BinarySearchTreeNode leftNode;
    private BinarySearchTreeNode rightNode;

    BinarySearchTreeNode(int value)
    {
        data=value;
    }

    public void add(int value)
    {
        if(value==data)
        {
            //this tree does not support duplicate value
            return;
        }
        else if(value<data)
        {
            //insert into its left node
            if(leftNode==null)
                leftNode=new BinarySearchTreeNode(value);
            else
                leftNode.add(value);
        }
        else
        {
            //insert into its right node
            if(rightNode==null)
                rightNode=new BinarySearchTreeNode(value);
            else
                rightNode.add(value);
        }
    }

    public void inOrderTraversal()
    {
        if(leftNode!=null)
            leftNode.inOrderTraversal();
        System.out.print(data+", ");
        if(rightNode!=null)
            rightNode.inOrderTraversal();
    }

    public BinarySearchTreeNode get(int value)
    {
        if(value==data)
            return this;
        else if(value<data)
        {
            if(leftNode!=null)
                return leftNode.get(value);
        }
        else if(value>data)
        {
            if(rightNode!=null)
                return rightNode.get(value);
        }

        return null;
    }

    public int min()
    {
        if(leftNode==null)
            return data;
        else
            return leftNode.min();
    }

    public int max()
    {
        if(rightNode==null)
            return data;
        else
            return rightNode.max();
    }

    @Override
    public String toString() {
        return "Data= "+String.valueOf(data);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinarySearchTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinarySearchTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinarySearchTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
