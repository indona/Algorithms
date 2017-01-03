import java.lang.*;
import java.util.*;

public class NumberOfIslands2
{
    public static List<Integer> numIslands2(int m, int n, int[][] positions)
    {
        List<Integer> result=new ArrayList<Integer>();

        //Sanity
        if((m==0 && n==0) || positions==null || positions.length==0)
            return result;

        //Create the root ArrayList
        int[] rootArray=new int[m*n];
        Arrays.fill(rootArray, -1);

        //Process each positions
        int[][] directions=new int[][]{{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        int islandCount=0;

        //For each position, set the root to itself. Process it and its neighbors.
        for(int[] position: positions)
        {
            islandCount++;
            int index=(position[0]*n)+position[1];
            rootArray[index]=index;
            //Process each of the '1' neighbour and see if they belong to the same root.
            //If yes, then move to the next neighbor.
            //If no, link this neighbor to the current Node and set its root to the current element.
            for(int i=0;i<4;i++)
            {
                int row=position[0]+directions[i][0];
                int col=position[1]+directions[i][1];

                if(row>=0 && row<m && col>=0 && col<n && rootArray[row*n+col]!=-1)
                {
                    int currentRoot=findRoot(rootArray, row*n+col);
                    if(currentRoot!=index)
                    {
                        rootArray[currentRoot]=index;
                        islandCount--;
                    }
                }
            }
            result.add(islandCount);
        }
        return result;
    }

    public static int findRoot(int[] rootArray, int index)
    {
        while(rootArray[index]!=index)
            index=rootArray[index];

        return index;
    }

    public static void main(String[] args)
    {
        int[][] positions=new int[][] {{0,0}, {0,1}, {1,2}, {2,1}};
        List<Integer> result=new ArrayList<Integer>();
        result=numIslands2(3, 3, positions);
        System.out.println("Islands: "+ Arrays.toString(result.toArray()));
    }
}
