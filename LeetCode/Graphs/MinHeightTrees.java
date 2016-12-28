import java.util.*;
import java.util.LinkedList.*;
import java.lang.*;

public class MinHeightTrees
{
    public static List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        List<Integer> result=new ArrayList<Integer>();

        //Sanity checks
        if(n==1)
        {
            result.add(0);
            return (result);
        }
        if(n==0 || edges==null || edges.length==0)
            return result;

        //Create the graph
        HashMap<Integer, HashSet<Integer>> graph=new HashMap<Integer, HashSet<Integer>>();
        //Initialize the adjacency list for each node
        for(int i=0;i<edges.length;i++)
        {
            int[] edge=edges[i];
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0], new HashSet<Integer>());
            if(!graph.containsKey(edge[1]))
                graph.put(edge[1], new HashSet<Integer>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //Find nodes with degree 1 and remove them from the list for Topological Sort
        List<Integer> leaves=new ArrayList<Integer>();
        for(int node: graph.keySet())
        {
            if(graph.get(node).size()==1)
                leaves.add(node);
        }

        //Start the topological sort
        while(n>2)
        {
            n-=leaves.size();
            for(int leaf: leaves)
            {
                graph.remove(leaf);
                for(int node: graph.keySet())
                    graph.get(node).remove(leaf);
            }

            List<Integer> newLeaves=new ArrayList<Integer>();
            for(int node: graph.keySet())
            {
                if(graph.get(node).size()==1)
                    newLeaves.add(node);
            }
            leaves.clear();
            leaves=newLeaves;
        }

        result.addAll(graph.keySet());
        return result;
    }

    public static void main(String args[])
    {
        List<Integer> result=new ArrayList<Integer>();

        int n = 7;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}, {5,6}};
        result=findMinHeightTrees(n, edges);
        System.out.println("MHT roots: "+ Arrays.toString(result.toArray()));

        int n2=4;
        int[][] edges2 = {{1, 0}, {1, 2}, {1, 3}};
        result.clear();
        result=findMinHeightTrees(n2, edges2);
        System.out.println("MHT roots: "+ Arrays.toString(result.toArray()));

        int n3 = 6;
        int[][] edges3 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        result=findMinHeightTrees(n3, edges3);
        System.out.println("MHT roots: "+ Arrays.toString(result.toArray()));
    }
}
