import java.util.*;
import java.lang.*;

public class Subsets_78
{
    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, resultSet, new ArrayList<>(), 0);
        return resultSet;
    }

    public static void backtrack(int[] nums, List<List<Integer>> resultSet, List<Integer> subset, int index)
    {
        resultSet.add(new ArrayList<>(subset));
        System.out.println("Subset: "+Arrays.toString(subset.toArray()));

        for(int i=index;i<nums.length;i++)
        {
            subset.add(nums[i]);
            backtrack(nums, resultSet, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String args[])
    {
        int[] nums={1,2,3};
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        resultSet=subsets(nums);
        System.out.println("Nums: "+Arrays.toString(nums)+"\nSubsets: "+Arrays.toString(resultSet.toArray()));
    }
}
