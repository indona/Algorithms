import java.util.*;
import java.lang.*;

class GenerateParentheses
{
    public static List<String> generateParentheses(int n)
    {
        List<String> resultSet=new ArrayList<String>();
        _generateParenthesis(n, n, "", resultSet);
        return resultSet;
    }

    public static void _generateParenthesis(int leftRemaining, int rightRemaining, String result, List<String> resultSet)
    {
        if(leftRemaining==0 && rightRemaining==0)
        {
            resultSet.add(result);
            return;
        }

        if(leftRemaining>0) //When there are ( left to be used.
            _generateParenthesis(leftRemaining-1, rightRemaining, result+"(", resultSet);

        //Invalid cases:
        //) - cannot start with a )
        //or ()()) - cannot end with an extra )
        //i.e. Till rightRemaining is greater than leftRemaining
        if(leftRemaining<rightRemaining)
            _generateParenthesis(leftRemaining, rightRemaining-1, result+")", resultSet);
    }

    public static void main(String args[])
    {
        List<String> resultSet=new ArrayList<String>();
        resultSet=generateParentheses(3);
        System.out.println("For n=3, Parenthesis combinations: \n"+Arrays.toString(resultSet.toArray())+"\n");

        resultSet=generateParentheses(5);
        System.out.println("For n=7, Parenthesis combinations: \n"+Arrays.toString(resultSet.toArray()));
    }
}
