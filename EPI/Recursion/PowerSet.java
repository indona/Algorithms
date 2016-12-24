import java.util.*;
import java.lang.*;

class PowerSet
{
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet)
    {
        List<List<Integer>> powerSet=new ArrayList<List<Integer>>();
        int n=inputSet.size();

        if(n<=0)
            return powerSet;

        for(int i=0;i<(1<<n);i++)
        {
            List<Integer> subset=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                    subset.add(inputSet.get(j));
            }
            powerSet.add(subset);
        }
        return powerSet;
    }

    public static void main(String args[])
    {
        List<Integer> inputSet=new ArrayList<Integer>()
        {{
            add(1);
            add(5);
            add(8);
            add(9);
        }};

        List<List<Integer>> resultSet=new ArrayList<List<Integer>>();
        resultSet=generatePowerSet(inputSet);
        System.out.println("Input set: "+ Arrays.toString(inputSet.toArray()));

        int i=1;
        for(List<Integer> set: resultSet)
        {
            System.out.println("Set "+i+": "+Arrays.toString(set.toArray()));
            i++;
        }
    }
}
