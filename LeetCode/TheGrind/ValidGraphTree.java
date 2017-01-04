import java.util.*;
import java.lang.*;

public class ValidGraphTree
{
    public static boolean validTree(int n, int[][] edges)
    {
        if(n==0 && (edges.length==0 || edges==null))
            return false;

        if(n==0)
            return true;

        //Initialize the root array, and set all roots to -1.
        int[] rootArray=new int[n];
        Arrays.fill(rootArray, -1);

        //Process all edges
        for(int i=0; i<edges.length;i++)
        {
            //Find the root for the vertices of this edge
            int endA=findRoot(rootArray, edges[i][0]);
            int endB=findRoot(rootArray, edges[i][1]);

            //If both the roots are same, it means both the nodes belongs to the same tree and we are revisiting some link within the same tree i.e. there is cycle. Hence return false.
            if(endA==endB)
                return false;

            //Else attach one vertex to the other and update the root.
            rootArray[endA]=endB;
        }
        //If all the edges are covered without breaking the cycle condition, check if number of edges=(vertices-1). If yes, return true.
        return (edges.length==n-1);
    }

    public static int findRoot(int[] rootArray, int end)
    {
        //Find the root recursively
        while(rootArray[end]!=-1)
            end=rootArray[end];

        return end;
    }

    public static void main(String args[])
    {
        int[][] edges={{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("For n=5, Status: "+validTree(5, edges));

        int[][] edges1={{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println("For n=5, Status: "+validTree(5, edges1));
    }
}
