package com.company;
import java.util.*;


public class Test{
    public static void main(String[] args) throws Exception {
        Graph g=new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        g.addVertex("H");
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(0,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(4,7);

        g.bfs(0);
    }
}

class Graph
{
    private final int MAX_VERTS=20;
    private Vertex vertexList[];
    private int[][] adjMat;
    private int nVerts;

    public Graph()
    {
        vertexList=new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for(int i=0;i<MAX_VERTS;i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j]=0;
            }
        }
    }

    public void addVertex(String label)
    {
        vertexList[nVerts++]=new Vertex(label);
    }

    public void addEdge(int start,int end)
    {
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    public int getadjUnvisitedVertex(int v)
    {
        for(int i=0;i<nVerts;i++)
        {
            if(adjMat[v][i]==1 && vertexList[i].wasvisited==false)
            {
                return i;
            }
        }
        return -1;
    }

    public void dfs(int startVertex)
    {
        Deque<Integer> stack=new LinkedList<Integer>();
        System.out.println(vertexList[startVertex].label);
        vertexList[startVertex].wasvisited=true;
        stack.push(startVertex);
        while(!stack.isEmpty())
        {
            int v=getadjUnvisitedVertex(stack.peek());
            if(v==-1)
                stack.pop();
            else
            {
                vertexList[v].wasvisited=true;
                System.out.println(vertexList[v].label);
                stack.push(v);
            }
        }

        for(int i=0;i<nVerts;i++)
            vertexList[i].wasvisited=false;
    }

    public void bfs(int startVertex)
    {
        Queue<Integer> queue=new LinkedList<Integer>();
        System.out.println(vertexList[startVertex].label);
        vertexList[startVertex].wasvisited=true;
        queue.offer(startVertex);
        int v2;

        while(!queue.isEmpty())
        {
            int v1=queue.poll();

            while((v2=getadjUnvisitedVertex(v1))!=-1)
            {
                System.out.println(vertexList[v2].label);
                vertexList[v2].wasvisited = true;
                queue.offer(v2);
            }
        }


        for(int i=0;i<nVerts;i++)
            vertexList[i].wasvisited=false;
    }
}

class Vertex
{
    public String label;
    public boolean wasvisited;

    public Vertex(String label)
    {
        this.label=label;
        wasvisited=false;
    }
}
