import java.util.*;
import java.lang.*;

class AllPalindromicDecompositions
{
    public static List<List<String>> generateAllPalindromicDecompositions(String input)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> partition = new ArrayList<String>();
        _generate(0, input, partition, result);

        return result;
    }

    public static void _generate(int index, String input, List<String> partition, List<List<String>> result)
    {
        if(index==input.length())
        {
            ArrayList<String> partialResult= new ArrayList<String>(partition);
            result.add(partialResult);
            return;
        }
        for(int i=index+1;i<=input.length();i++)
        {

            String prefix=input.substring(index, i);
            if(isPalindrome(prefix))
            {
                partition.add(prefix);
                _generate(i, input, partition, result);
                partition.remove(partition.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String input)
    {
        for(int i=0;i<=input.length()/2;i++)
        {
            if(input.charAt(i)!=input.charAt(input.length()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        List<List<String>> result = new ArrayList<List<String>>();

        String input="0204451881";
        result=generateAllPalindromicDecompositions(input);
        System.out.println("Input string: "+input);
        for(List<String> decomposition: result)
            System.out.println("Partition: "+Arrays.toString(decomposition.toArray()));
    }
}
