import java.util.*;
import java.lang.*;

class GeneratePermutations
{
    public static List<List<Integer>> generateAllPermutations(List<Integer> input)
    {
        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        _generatePermutations(0, input, resultSet);
        return resultSet;
    }

    public static void _generatePermutations(int index, List<Integer> input, List<List<Integer>> resultSet)
    {
        if(index==input.size()-1)
        {
            ArrayList<Integer> list=new ArrayList<Integer>(input);
            resultSet.add(list);
            return;
        }

        for(int i=index;i<input.size();i++)
        {
            Collections.swap(input, i, index);
            _generatePermutations(index+1, input, resultSet);
            Collections.swap(input, i, index);
        }
    }

    public static void main(String args[])
    {
        List<Integer> input=new ArrayList<Integer>(){{
            add(7);
            add(3);
            add(5);
        }};

        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        resultSet=generateAllPermutations(input);

        System.out.println("Input: "+Arrays.toString(input.toArray()));
        int i=1;
        for(List<Integer> permutation: resultSet)
        {
            System.out.println("Permutation "+i+": "+Arrays.toString(permutation.toArray()));
            i++;
        }
    }
}
