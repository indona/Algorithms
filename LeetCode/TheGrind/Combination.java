import java.lang.*;
import java.util.*;

public class Combination
{
    public static List<List<Integer>> generateCombinations(int n, int k)
    {
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();

        if(n<=0 || n<k)
            return resultSet;

        List<Integer> combination=new ArrayList<Integer>();
        _generateCombinations(n, k, resultSet, combination, 1);
        return resultSet;
    }

    public static void _generateCombinations (int n, int k, List<List<Integer>> resultSet, List<Integer>combination, int index)
    {
        if(combination.size()==k)
        {
            resultSet.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i=index;i<=n;i++)
        {
            combination.add(i);
            _generateCombinations(n, k, resultSet, combination, i+1);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String args[])
    {
        List<List<Integer>> r=new ArrayList<List<Integer>>();
        System.out.println("N=4, K=2 ResultSet:\n");
        r=generateCombinations(4, 2);
        for(List<Integer> c: r)
            System.out.println(Arrays.toString(c.toArray()));
    }
}
