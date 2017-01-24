import java.lang.*;
import java.util.*;

class RandomizedCollection
{
    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random rand=new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection()
    {
        nums=new ArrayList<Integer>();
        map=new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val)
    {
        boolean contains=map.containsKey(val);
        if(!contains)
            map.put(val, new HashSet<Integer>());

        map.get(val).add(nums.size());
        nums.add(val);

        return !contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val)
    {
        if(!map.containsKey(val))
            return false;

        int locToRemove=map.get(val).iterator().next();
        map.get(val).remove(locToRemove);

        if(locToRemove<nums.size()-1)
        {
            int lastEntry=nums.get(nums.size()-1);
            nums.set(locToRemove, lastEntry);
            map.get(lastEntry).remove(nums.size()-1);
            map.get(lastEntry).add(locToRemove);
        }

        nums.remove(nums.size()-1);
        if(map.get(val).size()==0)
            map.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom()
    {
        return nums.get(rand.nextInt(nums.size()));
    }
}

public class RandomizedCollectionSolution
{
    public static void main(String args[])
    {
        RandomizedCollection obj = new RandomizedCollection();
        boolean param_1 = obj.insert(10);
        System.out.println("10 insert status: "+param_1);
        boolean param_2 = obj.remove(20);
        System.out.println("20 remove status: "+param_2);
        param_1 = obj.insert(10);
        System.out.println("10 re-insert status: "+param_1);
        param_1 = obj.insert(10);
        System.out.println("10 re-insert status: "+param_1);
        int param_3 = obj.getRandom();
        System.out.println("Get random status: "+param_3);
        param_2 = obj.remove(10);
        System.out.println("20 remove status: "+param_2);
    }
}
