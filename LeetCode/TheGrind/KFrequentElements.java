import java.util.*;
import java.lang.*;

class Tuple
{
    int num, freq;
    Tuple(int x, int y)
    {
        num=x;
        freq=y;
    }
}

public class KFrequentElements
{
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        List<Integer> result=new ArrayList<Integer>();

        if(nums==null || nums.length==0)
            return result;

        //generate the frequency map for the given array of numbers
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }

        //To sort the numbers in an increasing order, use a priority queue (min-heap) with custom comparator. Insert elements into the queue.
        PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>(new Comparator<Tuple>()
        {
            public int compare(Tuple a, Tuple b)
            {
                return a.freq-b.freq;
            }
        });

        //Iterate through the HashMap and insert elements into the priority queue. Trim its size to K.
        for(Integer key: map.keySet())
        {
            Tuple t=new Tuple(key, map.get(key));
            pq.offer(t);
            if(pq.size()>k)
                pq.poll();
        }

        //Now extract elements from the heap. This is your top K elements. Reverse the order to get the result.
        while(!pq.isEmpty())
            result.add(pq.poll().num);

        Collections.reverse(result);
        return result;
    }

    public static void main(String args[])
    {
        int nums[]={1, 2, 4, 5, 1, 2, 1, 4, 3, 2, 2};
        List<Integer> result=new ArrayList<Integer>();
        result=topKFrequent(nums, 3);
        System.out.println("Result: "+Arrays.toString(result.toArray()));
    }
}
