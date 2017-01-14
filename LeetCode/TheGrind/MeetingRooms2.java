import java.lang.*;
import java.util.*;

class Interval
{
    int start;
    int end;
    Interval()
    {
        start = 0; end = 0;
    }
    Interval(int s, int e)
    {
        start = s;
        end = e;
    }
}

class IntervalComparator implements Comparator<Interval>
{
    @Override
    public int compare(Interval a, Interval b)
    {
        return a.end-b.end;
    }
}

public class MeetingRooms2
{
    //The idea behind this problem is to merge as many intervals as possible. First we sort the intervals by their end times. We maintain a priority queue to see if the intervals can be merged and merge as many of them as possible. Once a non-overlapping interval comes in, we add it to the heap and try to merge the remaining intervals with the new top. Repeat till all the intervals are processed.
    public static int minMeetingRooms(Interval[] intervals)
    {
        if(intervals==null || intervals.length==0)
            return 0;

        IntervalComparator ic=new IntervalComparator();
        Arrays.sort(intervals, ic);

        PriorityQueue<Interval> pq=new PriorityQueue<Interval>(ic);
        pq.add(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            Interval interval=pq.poll();

            //Check if this interval overlaps with the previous interval. If not, then the new interval can reuse the same room. Merge the intervals and update the end time to the new interval's end time.
            if(intervals[i].start>=interval.end)
                interval.end=intervals[i].end;

            //Else this interval cannot be merged with the previous interval and hence requires a new room of its own.
            else
                pq.add(intervals[i]);

            //In either case, we need to push back the original interval that we popped out so that we don't lose any data.
            pq.add(interval);
        }
        return pq.size();
    }

    public static void main(String args[])
    {
        Interval[] intervals=new Interval[3];
        intervals[0]=new Interval(0, 30);
        intervals[1]=new Interval(5, 10);
        intervals[2]=new Interval(15, 20);

        System.out.println("Number of rooms required: "+minMeetingRooms(intervals));
    }
}
