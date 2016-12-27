import java.util.*;

public class TopKFrequentElements
{
    public static List<Integer> topKFrequent(int[] nums, int k)
    {
        HashMap<Integer, Integer> frequencyMap=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(frequencyMap.containsKey(nums[i]))
                frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);
            else
                frequencyMap.put(nums[i], 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet())
        {
            heap.add(entry);
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<k;i++)
        {
            Map.Entry<Integer, Integer> entry=heap.poll();
            result.add(entry.getKey());
        }

        return result;
    }

    public static void main(String args[])
    {
        int[] nums={1,1,1,2,2,3, 10, 10, 10, 10};
        int k=2;

        List<Integer> result = new ArrayList<Integer>();
        result=topKFrequent(nums, k);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
