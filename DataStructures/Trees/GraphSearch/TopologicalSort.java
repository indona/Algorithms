import java.util.*;

class Graph
{
    int vertices;
    LinkedList<Integer> adjList[];
    ArrayList<Integer> traversal = new ArrayList<Integer>();
    int visitedNodes=0;

    Graph(int vertices)
    {
        this.vertices=vertices;
        adjList=new LinkedList[vertices];

        for(int i=0;i<vertices;i++)
        {
            adjList[i]=new LinkedList<Integer>();
        }
    }

    void addEdge(int source, int destination)
    {
        adjList[source].add(destination);
    }

    void topologicalSort()
    {
        int indegree[] = new int[vertices];

        for(int i=0;i<vertices;i++)
        {
            LinkedList<Integer> temp = adjList[i];
            for(int node: temp)
            {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<vertices;i++)
        {
            if(indegree[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty())
        {
            int nodeToAdd = queue.poll();
            traversal.add(nodeToAdd);

            for(int node : adjList[nodeToAdd])
            {
                indegree[node]--;
                if(indegree[node]==0)
                    queue.add(node);
            }
            visitedNodes++;
        }

        if(visitedNodes!=vertices)
            System.out.println("There is a cycle. No topological sort.");
        else
            System.out.println("Topological sort: "+ Arrays.toString(traversal.toArray()));
    }
}

public class TopologicalSort
{
    public static void main(String args[])
    {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
