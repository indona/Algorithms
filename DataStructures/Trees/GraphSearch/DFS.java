import java.util.*;

class Graph
{
    int vertices;
    LinkedList<Integer>[] adjList;
    ArrayList<Integer> traversal;
    ListIterator<Integer> iterator;

    Graph(int vertices)
    {
        this.vertices=vertices;
        adjList=new LinkedList [vertices];
        for(int i=0;i<vertices;i++)
        {
            adjList[i]=new LinkedList<Integer>();
        }
    }

    void addEdge(int source, int destination)
    { 
        adjList[source].add(destination);
        System.out.println("Added "+destination+" to "+source);
    }

    ArrayList<Integer> DFS(int sourceVertex)
    {
        boolean[] visited = new boolean[vertices];
        traversal = new ArrayList<Integer>();

        for(int i=0;i<vertices;i++)
        {
            if(!visited[sourceVertex])
                DfsTraverse(sourceVertex, visited);
        }

        return traversal;
    }

    void DfsTraverse(int sourceVertex, boolean[] visited)
    {
        visited[sourceVertex]=true;
        traversal.add(sourceVertex);
        iterator=adjList[sourceVertex].listIterator();

        while(iterator.hasNext())
        {
            int newVertex=iterator.next();
            if(!visited[newVertex])
            {
                DfsTraverse(newVertex, visited);
            }
        }
    }
}

public class DFS
{
    public static void main(String args[])
    {
        Graph graph = new Graph(5);
        ArrayList<Integer> traversal = new ArrayList<Integer>();

        /*        graph.addEdge(0,2);
                  graph.addEdge(2,0);
                  graph.addEdge(1,2);
                  graph.addEdge(3,3);
                  graph.addEdge(0,1);
                  graph.addEdge(2,3);
                  */
        graph.addEdge(0, 1);
        graph.addEdge(3, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4,4);

        traversal=graph.DFS(0);
        System.out.println(Arrays.toString(traversal.toArray()));
    }
}
