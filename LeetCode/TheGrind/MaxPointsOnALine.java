import java.lang.*;
import java.util.*;

class Point
{
    int x;
    int y;
    Point()
    {
        this.x = 0; this.y = 0;
    }

    Point(int a, int b)
    {
        this.x = a; this.y = b;
    }
}

class MaxPointsOnALine
{
    public static int maxPoints(Point[] points)
    {
        if( points==null || points.length==0)
            return 0;

        //One point or two points would always be in the same line.
        if(points.length<=2)
            return points.length;

        //Idea: Two points can be on the same line iff their slopes are same. For this, consider each pair of points and calculate their slopes. Maintain the slopes and its counter in a HashMap.
        Map<Double, Integer> slopeMap=new HashMap<Double, Integer>();
        int max=0;

        for(int i=0;i<points.length;i++)
        {
            int duplicate=1, vertical=0;
            slopeMap.clear();
            for(int j=i+1;j<points.length;j++)
            {
                //Check for duplicates and verticles (same X)
                if(points[i].x==points[j].x)
                {
                    if(points[i].y==points[j].y) //For duplicates - same X, same Y
                        duplicate++;
                    else //Verticals - Same X, different Y
                        vertical++;
                }
                else //Perform slope calculation and see if they are in the same line
                {
                    double slope;
                    if(points[i].y==points[j].y) //Same y - different x => Same slope (0)
                        slope=0.0;
                    else
                        slope=(double)(points[j].y-points[i].y)/(points[j].x-points[i].x);

                    //Store/Update the slope and its counter in the HashMap
                    if(slopeMap.containsKey(slope))
                        slopeMap.put(slope, (slopeMap.get(slope)+1));
                    else
                        slopeMap.put(slope, 1);
                }
            }

            //For the point points[i], find the maximum slope count and add the duplicate list to it. If this value is greater than current max, the update max.
            for(Integer slopeCount: slopeMap.values())
                max=Math.max(max, (slopeCount+duplicate));

            //Now check if the number of duplicate points + vertical points > current max. If yes, update it.
            max=Math.max(max, (vertical+duplicate));
        }
        return max;
    }

    public static void main(String args[])
    {
        Point[] points={new Point(84,250), new Point(0,0), new Point(1,0), new Point(0,-70), new Point(0,-70), new Point(1,-1), new Point(21,10), new Point(42,90), new Point(-42,-230)};
        System.out.println("Max: "+maxPoints(points));
    }
}
