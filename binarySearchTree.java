package com.company;
import java.util.*;


public class Test{
    public static void main(String[] args) {
        /**
         * implement a binary search tree
         */

        BinarySearchTree btree=new BinarySearchTree();
        btree.add(25);
        btree.add(20);
        btree.add(15);
        btree.add(27);
        btree.add(30);
        btree.add(29);
        btree.add(26);
        btree.add(22);
        btree.add(32);
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

    public void inOrderTraversal()
    {
        if(root!=null)
            root.inOrderTraversal();
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
