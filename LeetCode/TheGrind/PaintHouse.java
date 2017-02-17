import java.util.*;

public class PaintHouse
{
    public static int minCost(int[][] cost)
    {
        if(cost.length==0)
            return 0;

        for(int i=1;i<cost.length;i++)
        {
            //Cost of painting this house red => previous house is painted blue/green, whichever is minimum
            cost[i][0]+=Math.min(cost[i-1][1], cost[i-1][2]);

            //Cost of painting this house blue => previous house is painted red/green, whichever is minimum
            cost[i][1]+=Math.min(cost[i-1][0], cost[i-1][2]);

            //Cost of painting this house green => previous house is painted red/blue, whichever is minimum
            cost[i][2]+=Math.min(cost[i-1][0], cost[i-1][1]);
        }
        //At the end, find the minimum of the three colors => thats's the answer
        int l=cost.length-1;
        return Math.min(cost[l][0], Math.min(cost[l][1], cost[l][2]));
    }

    public static void main(String args[])
    {
        int[][] cost={{1,2,3},
                      {2,4,5},
                      {3,1,2},
                      {2,7,0}};
        System.out.println("Min cost: "+minCost(cost));
    }
}
