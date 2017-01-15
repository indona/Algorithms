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
        start = s; end = e;
    }
}

public class MergeIntervals
{
    //The idea behind this problem is to merge as many overlapping intervals as possible. Overlap between two intervals can be found by checking the start time of the next interval and end time of the current interval. If (next_start < current_end) then the intervals overlap and the merged interval's end would be the max of the two.
    //To do this we sort the intervals by tehir start time and run through the list trying to find maximum number of overlapping intervals
    public static List<Interval> merge(List<Interval> intervals)
    {
        List<Interval> result=new ArrayList<Interval>();

        if(intervals.size()==0 || intervals==null)
            return result;

        //Sorting the intervals with their start time
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start-b.start;
            }
        });

        int start=intervals.get(0).start;
        int end=intervals.get(0).end;

        //Iterate through all the intervals and find the maximum number of overlapping intervals
        for(Interval i: intervals)
        {
            if(i.start<=end)
                end=Math.max(end, i.end);
            else
            {
                result.add(new Interval(start, end));
                start=i.start;
                end=i.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String args[])
    {
        List<Interval> intervals=new ArrayList<Interval>(){{
          add(new Interval(1,3));
          add(new Interval(2,6));
          add(new Interval(8,10));
          add(new Interval(15,18));
        }};

        List<Interval> result=new ArrayList<Interval>();
        result=merge(intervals);

        for(Interval i:result)
            System.out.println(i.start+", "+i.end);
    }
}
