import java.lang.*;
import java.util.*;

public class AddOperators
{
    public static List<String> addOperators(String num, int target)
    {
        //The idea behind this problem is to explore all options and combinations of operators using backtracking and DFS.
        //We look at each digit and try to apply operatos between all possible gaps in a given string.
        //Whichever combination evaluates to the given target value => we add it to the resultset.
        List<String> result=new ArrayList<String>();

        if(num==null || num.length()==0)
            return result;

        helper(result, "", num, target, 0, 0, 0);
        return result;
    }

    public static void helper(List<String> result, String exp, String num, int target, int index, long expVal, long mul)
    {
        if(index==num.length())
        {
            if(expVal==target)
                result.add(exp);
            return;
        }
        for(int i=index;i<num.length();i++)
        {
            //To avoid such scenarios: num=105, target=5
            //Result= [1*0+5, 1*5, 10-5] | Expected result=[1*0+5, 10-5] 
            if(i!=index && num.charAt(index)=='0')
                break;

            long curr=Long.parseLong(num.substring(index, i+1));

            if(index==0)
                helper(result, exp+curr, num, target, i+1, curr, curr);
            else
            {
                helper(result, exp+ "+" +curr, num, target, i+1, expVal+curr, curr);
                helper(result, exp+ "-" +curr, num, target, i+1, expVal-curr, -curr);
                helper(result, exp+ "*" +curr, num, target, i+1, expVal-mul + mul*curr, mul*curr);
            }
        }
    }

    public static void main(String args[])
    {
        List<String> result=new ArrayList<String>();
        // result=addOperators("11201", 2);
        // System.out.println(Arrays.toString(result.toArray()));

        result.clear();
        result=addOperators("105", 5);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
