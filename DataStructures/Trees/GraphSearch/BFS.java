import java.util.*;

class Graph
{
    int vertices;
    LinkedList<Integer> adjList[];
    ArrayList<Integer> traversal = new ArrayList<Integer>();

    Graph(int vertices)
    {
        this.vertices=vertices;
        adjList=new LinkedList[vertices];
        for(int i=0;i<vertices;i++)
        {
            adjList[i]=new LinkedList();
        }
    }

    void addEdge(int source, int destination)
    {
        adjList[source].add(destination);
    }

    ArrayList<Integer> BfsTraversal(int source)
    {
        boolean visited[] = new boolean[vertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[source]=true;
        queue.add(source);

        while(queue.size()!=0)
        {
            source=queue.poll();
            traversal.add(source);

            Iterator<Integer> iterator=adjList[source].listIterator();
            while(iterator.hasNext())
            {
                int newNode=iterator.next();
                if(visited[newNode]==false)
                {
                    visited[newNode]=true;
                    queue.add(newNode);
                }
            }
        }
        return traversal;
    } 
}

public class BFS
{
    public static void main(String args[])
    {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(4, 4);
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        traversal = graph.BfsTraversal(0);

        System.out.println(Arrays.toString(traversal.toArray()));
    }
}
