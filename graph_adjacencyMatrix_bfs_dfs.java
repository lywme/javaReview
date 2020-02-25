import java.util.*;

public class scratch
{
    public static void main(String[] args)
    {
        /**
         * An implement of Graph using adjacent matrix
         */
        Graph g=new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);

//        g.dfs();
//        g.bfs();
        g.bfsExtension();
    }
}

class Graph
{
    //Vertex list of name of all vertices
    Vertex[] vertexList;
    //adjacency matrix
    int[][] adjacencyMatrix;
    //counter for how many of vertices
    int nVertice;
    //max number of vertices
    int maxVertice;


    public Graph()
    {
        maxVertice=10;
        vertexList=new Vertex[maxVertice];
        adjacencyMatrix=new int[maxVertice][maxVertice];
        nVertice=0;
        for(int i=0;i<maxVertice;i++)
            for(int j=0;j<maxVertice;j++)
            {
                adjacencyMatrix[i][j]=0;
            }

    }

    public void addVertex(char name)
    {
        vertexList[nVertice++]=new Vertex(name);
    }

    public void addEdge(int from,int to)
    {
        adjacencyMatrix[from][to]=1;
        adjacencyMatrix[to][from]=1;
    }

    public int getAdjUnVisitedV(int v)
    {
        for(int i=0;i<nVertice;i++)
        {
            if(adjacencyMatrix[v][i]==1 && vertexList[i].wasVisited==false)
                return i;
        }
        return -1;
    }

    public void dfs()
    {
        Deque<Integer> stack=new LinkedList<Integer>();
        //visit vertex 0 first
        vertexList[0].wasVisited=true;
        printVertex(0);
        stack.push(0);

        while(!stack.isEmpty())
        {
            int v=getAdjUnVisitedV(stack.peek());
            if(v==-1)
            {
                stack.pop();
            }
            else
            {
                vertexList[v].wasVisited=true;
                printVertex(v);
                stack.push(v);
            }
        }

        //reset wasVisited mark
        for(int v=0;v<nVertice;v++)
            vertexList[v].wasVisited=false;
    }

    public void bfs()
    {
        //start from vertex 0
        int currentV=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        vertexList[currentV].wasVisited=true;
        printVertex(currentV);
        queue.offer(currentV);

        while(!queue.isEmpty())
        {
            //get current vertex's all neighbour which have not visited.
            currentV=queue.peek();
            for(int i=0;i<nVertice;i++)
            {
                //traverse all the vertexlist
                if(adjacencyMatrix[currentV][i]==1 && vertexList[i].wasVisited==false)
                {
                    queue.offer(i);
                    vertexList[i].wasVisited=true;
                    printVertex(i);
                }
            }
            queue.poll();
        }
    }

    public void bfsExtension()
    {
        //Extension: store all the vertex's predecessor vertex
        int[][] pre=new int[2][nVertice];

        for(int j=0;j<nVertice;j++)
        {
            pre[1][j]=0;
        }
        for(int i=0;i<nVertice;i++)
            pre[0][i]=i;

        //start from vertex 0
        int currentV=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        vertexList[currentV].wasVisited=true;
        printVertex(currentV);
        queue.offer(currentV);

        while(!queue.isEmpty())
        {
            //get current vertex's all neighbour which have not visited.
            currentV=queue.peek();
            for(int i=0;i<nVertice;i++)
            {
                //traverse all the vertexlist
                if(adjacencyMatrix[currentV][i]==1 && vertexList[i].wasVisited==false)
                {
                    pre[1][i]=currentV;
                    queue.offer(i);
                    vertexList[i].wasVisited=true;
                    printVertex(i);
                }
            }
            queue.poll();
        }

        System.out.println();
        for(int i=0;i<2;i++)
        {
            for (int j = 0; j < nVertice; j++) {
                System.out.print(pre[i][j]);
            }
            System.out.println();
        }
    }

    public void printVertex(int v)
    {
        System.out.print(vertexList[v].vertexName+" ");
    }
}

class Vertex
{
    public char vertexName;
    public boolean wasVisited;

    public Vertex(char name)
    {
        vertexName=name;
    }
}
