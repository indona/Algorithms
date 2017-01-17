import java.lang.*;
import java.util.*;

public class MinArrowShots
{
    public static int findMinArrowShots(int[][] points)
    {
        if(points==null || points.length==0 || points[0].length==0)
            return 0;

        //The idea behind this problem is to sort the ballons according to their overlaps. We sort them by the starting x coordinates. In case starting x coordinates are same, we sort them based on the ending x-coordinates.
        //For all overlapping balloons we need just one arrow. The moment a non-overlapping balloon comes in, we increment the arrow counter.
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0]!=b[0])
                    return a[0]-b[0];
                else
                    return a[1]-b[1];
            }
        });

        //Here we iterate through all the balloons and increment the numArrows whenever we find a non overlapping balloon. In that case we also need to reset the arrow range to the current balloon's diameter.
        int numArrows=1;
        int arrowRange=points[0][1];
        for(int i=1;i<points.length;i++)
        {
            int[] balloon=points[i];
            if(balloon[0]<=arrowRange)
                arrowRange=Math.min(arrowRange, balloon[1]);
            else
            {
                numArrows++;
                arrowRange=balloon[1];
            }
        }
        return numArrows;
    }

    public static void main(String args[])
    {
        //int[][] points={{10,16}, {2,8}, {1,6}, {7,12}};
        int[][] points={{1,2},{2,3},{3,4},{4,5}};
        System.out.println("Minimum number of arrows required: " + findMinArrowShots(points));
    }
}
