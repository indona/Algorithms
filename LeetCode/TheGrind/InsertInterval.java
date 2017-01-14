import java.util.*;
import java.lang.*;

class Interval
{
    int start, end;
    Interval()
    {
        start=0; end=0;
    }

    Interval(int a, int b)
    {
        start=a;
        end=b;
    }
}

public class InsertInterval
{
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        List<Interval> result=new ArrayList<Interval>();
        List<Interval> post=new ArrayList<Interval>();

        int minStart=newInterval.start;
        int maxEnd=newInterval.end;

        for(Interval interval: intervals)
        {
            //Intervals whose end is before the new intervals start, add them directly to the list
            if(interval.end<newInterval.start)
                result.add(interval);

            //Intervals whose start is after the new intervals end, add them directly to the list
            else if(interval.start>newInterval.end)
                post.add(interval);

            //Intervals with start or end overlapping with the newInterval
            else
            {
                minStart=Math.min(minStart, interval.start);
                maxEnd=Math.max(maxEnd, interval.end);
            }
        }
        result.add(new Interval(minStart, maxEnd));
        result.addAll(post);
        return result;
    }

    public static void main(String args[])
    {
        /*
        List<Interval> intervals=new ArrayList<Interval>(){{
          add(new Interval(1,3));
          add(new Interval(6,9));
        }};
        */

        List<Interval> intervals=new ArrayList<Interval>(){{
          add(new Interval(1,2));
          add(new Interval(3,5));
          add(new Interval(6,7));
          add(new Interval(8,10));
          add(new Interval(12,16));
        }};

        Interval newInterval=new Interval(4,9);

        List<Interval> results=new ArrayList<Interval>();
        results=insert(intervals, newInterval);

        for(Interval i:results)
            System.out.println(i.start+", "+i.end);
    }
}
