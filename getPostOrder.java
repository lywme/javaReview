import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class scratch
{

    public static void main(String[] args)
    {
        System.out.println(getPostOrder("ABDEGCF","DBGEACF"));
    }

    /**
     * 输入一个二叉树的前序和中序遍历字符串，求出二叉树的后续遍历字符串
     * @param preOrder string of a binary tree in preOrder traversal
     * @param inOrder string of a binary tree in inOrder traversal
     * @return string of a binary tree in postOrder
     */
    public static String getPostOrder(String preOrder,String inOrder)
    {
        if(preOrder.isEmpty())
        {
            return "";
        }

        Character root=preOrder.charAt(0);
        int rootIndex=inOrder.indexOf(root);

        return getPostOrder(preOrder.substring(1,1+rootIndex),inOrder.substring(0,rootIndex))+getPostOrder(preOrder.substring(1+rootIndex),inOrder.substring(rootIndex+1))+root;
    }
}


