import java.util.*;
import java.lang.*;

class LongestNonDecreasingSubsequence
{
    public static int longestNonDecreasingSubsequenceLength(List<Integer> input)
    {
        Integer[] dpTable=new Integer[input.size()];
        Arrays.fill(dpTable, 1);

        for(int i=0;i<input.size();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(input.get(i)>=input.get(j))
                    dpTable[i]=Math.max(dpTable[i], dpTable[j]+1);
            }
        }

        return Collections.max(Arrays.asList(dpTable));
    }

    public static void main(String args[])
    {
        List<Integer> input=new ArrayList<Integer>()
        {{
          add(0);
          add(8);
          add(4);
          add(12);
          add(2);
          add(10);
          add(6);
          add(14);
          add(1);
          add(9);
        }};

        int length=longestNonDecreasingSubsequenceLength(input);
        System.out.println("For input: "+Arrays.toString(input.toArray())+" Length: "+length);
    }
}
