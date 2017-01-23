import java.lang.*;
import java.util.*;

//The idea behind this problem is:
//Scan all buildings from L->R
//Start at the first building and push it into the PQ. Since this let to a change is maxHeight (originally 0), add this to the skyLine.
//There can be multiple buildings starting at the same point, make sure you add all the buildings starting at a point to the PQ and add the max height to the skyLine.
//Keep doing this till you see the end of the current maxHeight (PQ top) building.
//When you see the PQ's top building's end, remove it from the PQ and remove all buildings which end before it. This ensures that buildings which are not visible behind this building are also removed along with this building.
//At every isntance check if the maxHeight has changed, if yes then update it and add it to the skyline.
//Once all the buildings are added, pop elements out of the PQ and update the heights in the skyline.

public class SkyLineProblem
{
    //Create a Building class for inserting elements into the priority queue. We create a separate class so that we can order the buildings based on their heights while being able to effectively extract the start and ends at the same time.
    public static class Building
    {
        int start, end, height;

        Building(int l, int r, int h)
        {
            start=l;
            end=r;
            height=h;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings)
    {
        List<int[]> skyLine=new ArrayList<int[]>();

        if(buildings==null || buildings.length==0)
            return skyLine;

        //Height based priority queue. Custom comparator to order buildings based on their heights
        PriorityQueue<Building> pq=new PriorityQueue<Building>(new Comparator<Building>(){
            public int compare(Building a, Building b)
            {
                return b.height-a.height;
            }
        });

        int i=0, loc=0, height=0;
        //Process the buildings from the left to right
        while(i<buildings.length && i<buildings.length || !pq.isEmpty())
        {
            //If the priority queue is empty or if you see the start of a new building before the end of the current PQ's TOS, then push the building into the priority queue.
            if(pq.isEmpty() || (i<buildings.length && buildings[i][0]<=pq.peek().end))
            {
                loc=buildings[i][0];
                pq.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
                i++;

                //If there are multiple buildings starting at this point, add all of them to the PriorityQueue
                while(i<buildings.length && buildings[i][0]==loc)
                {
                    pq.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
                    i++;
                }
            }
            //If you see the end of the PQ's current top, then pop that element and all the buildings whose end was before this building's end. After the repeated pop, check the height and left of the current PQ's top. Add that to the
            else
            {
                loc=pq.peek().end;
                //Repeatedly poll the buildings out of the PQ whose end is on or before the current TOS's end
                while(!pq.isEmpty() && pq.peek().end<=loc)
                {
                    pq.poll();
                }
            }

            //Now check if the maxHeight of the PQ has changed. If no, then move on. If ye, then this is a critical point and add this to the skyline.
            //If the PQ is empty, it means either we have reached the end of the buildings or we have reached the end of a building block. In either case, the new height is 0.
            if(pq.isEmpty())
            {
                height=0;
                int[] point={loc, height};
                skyLine.add(point);
            }
            //This means that the height has changed but we still have elements in the PQ. The new height would be the max height from the buildings currently present in the PQ. We find that using a peek.
            else if(height!=pq.peek().height)
            {
                height=pq.peek().height;
                int[] point={loc, height};
                skyLine.add(point);
            }
        }
        return skyLine;
    }

    public static void main(String args[])
    {
        // int[][] buildings={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        // int[][] buildings={{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings={{0,2,3},{2,5,3}};

        List<int[]> skyLine=new ArrayList<int[]>();
        skyLine=getSkyline(buildings);

        for(int[] i: skyLine)
            System.out.println(Arrays.toString(i));
    }
}
