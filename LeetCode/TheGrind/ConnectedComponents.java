import java.lang.*;
import java.util.*;

public class ConnectedComponents
{
    public static int countComponents(int n, int[][] edges)
    {
        if(edges==null || edges.length==0)
            return n;

        //Create a rootArray and fill it with -1.
        int count=n;
        int rootArray[]=new int[n];
        Arrays.fill(rootArray, -1);

        //Process each edge
        for(int i=0;i<edges.length;i++)
        {
            //Extract the edges and find their roots
            int vertexA=edges[i][0];
            int vertexB=edges[i][1];
            int rootA=findRoot(rootArray, vertexA);
            int rootB=findRoot(rootArray, vertexB);

            //If roots are not equal, i.e. the vertices belong to two different components -> connect the components by assigning the first as root of second. Decremenyt the counter.
            if(rootA!=rootB)
            {
                rootArray[rootB]=rootA;
                count--;
            }
        }
        return count;
    }

    public static int findRoot(int[] rootArray, int node)
    {
        while(rootArray[node]!=-1)
            node=rootArray[node];

        return node;
    }

    public static void main(String args[])
    {
        int[][] edges={{0, 1}, {1, 2}, {3, 4}};
        //System.out.println("Number of componenets: "+countComponents(5, edges));

        int[][] edges2={{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        // System.out.println("Number of componenets: "+countComponents(5, edges2));

        int[][] edges3={{0,1},{2,1},{2,0},{2,4}};
        System.out.println("Number of componenets: "+countComponents(5, edges3));
    }
}
