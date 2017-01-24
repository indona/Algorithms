import java.lang.*;
import java.util.*;

class RandomizedSet
{
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random rand=new Random();

    /** Initialize your data structure here. */
    public RandomizedSet()
    {
        nums=new ArrayList<Integer>();
        map=new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val)
    {
        if(map.containsKey(val))
            return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val)
    {
        if(!map.containsKey(val))
            return false;
        int position=map.get(val);
        if(position<nums.size())
        {
            int last=nums.get(nums.size()-1);
            nums.set(position, last);
            map.put(last, position);
        }
        map.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom()
    {
        return nums.get(rand.nextInt(nums.size()));
    }
}

public class RandomizedSetSolution
{
    public static void main(String args[])
    {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(10);
        System.out.println("10 insert status: "+param_1);
        param_1 = obj.insert(20);
        System.out.println("20 insert status: "+param_1);
        param_1 = obj.insert(30);
        System.out.println("30 insert status: "+param_1);
        boolean param_2 = obj.remove(10);
        System.out.println("Remove 10 status: "+param_2);
        param_2 = obj.remove(10);
        System.out.println("Remove 10 status: "+param_2);
        int param_3 = obj.getRandom();
        System.out.println("Get random status: "+param_3);

    }
}
