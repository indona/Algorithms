import java.util.*;
import java.lang.*;

class SubsetsSizeK
{
    public static List<List<Integer>> generateAllSubsetsSizeK(int n, int k)
    {
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        List<Integer> subset=new ArrayList<Integer>();
        _generateSubsets(1, k, n, subset, resultSet);
        return resultSet;
    }

    public static void _generateSubsets(int index, int k, int n, List<Integer> subset, List<List<Integer>> resultSet)
    {
        if(subset.size()==k)
        {
            ArrayList<Integer> result=new ArrayList<Integer>(subset);
            resultSet.add(result);
            return;
        }

        for(int i=index;i<=n;i++)
        {
            subset.add(i);
            _generateSubsets(i+1, k, n, subset, resultSet);
            subset.remove(subset.size()-1);
        }
    }

    public static void main(String args[])
    {
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        resultSet=generateAllSubsetsSizeK(5, 2);
        System.out.println("For n, k: 5, 2: ");
        for(List<Integer> subset: resultSet)
            System.out.println("Subsets: "+Arrays.toString(subset.toArray()));

        resultSet.clear();
        resultSet=generateAllSubsetsSizeK(6, 4);
        System.out.println("\nFor n, k: 6, 4: ");
        for(List<Integer> subset: resultSet)
            System.out.println("Subsets: "+Arrays.toString(subset.toArray()));
    }
}
