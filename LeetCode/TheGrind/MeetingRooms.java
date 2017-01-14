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
        return a.start-b.start;
    }
}

public class MeetingRooms
{
    public static boolean canAttendMeetings(Interval[] intervals)
    {
        if(intervals==null || intervals.length==0)
            return false;

        IntervalComparator ic=new IntervalComparator();
        Arrays.sort(intervals, ic);

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i].start<intervals[i-1].end)
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        Interval[] list=new Interval[3];
        list[0]=new Interval(0, 3);
        list[1]=new Interval(5, 15);
        list[2]=new Interval(15, 20);

        System.out.println("Status: "+canAttendMeetings(list));
    }
}
