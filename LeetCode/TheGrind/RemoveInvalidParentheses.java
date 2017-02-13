import java.lang.*;
import java.util.*;

public class RemoveInvalidParentheses
{
    public static List<String> removeInvalidParentheses(String s)
    {
        //The idea behind this problem is to start with the given string, use BFS to modify removing one ( or ) at a time and see if the modified string is a valid string or not.
        //BFS - to ensure minimum number of removals.
        //If we find any valid string at this level, we add it to the resultset and return (min removals).
        //Else we put the modified string in a queue to see if it will lead us to a valid string in the next level.
        //We also store the visited strings in a visited set to remove duplicates or inifite loops.

        List<String> result=new ArrayList<String>();

        //Sanity
        if(s==null)
            return result;

        //initialize the queue and visited set
        Set<String> visited=new HashSet<String>();
        Queue<String> q=new LinkedList<String>();
        boolean found=false;

        q.add(s);
        visited.add(s);

        while(!q.isEmpty())
        {
            s=q.poll();

            //Check if the current level has any valid string. If yes, we are done!
            if(isValid(s))
            {
                result.add(s);
                found=true;
            }

            //This is the minimum number of removals required. Stop exploring further levels. Process the rest of the elements in the queue.
            if(found)
                continue;

            //If no valid strings are found on this level, generate all possible combinations for each string and add them to the queue.
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!='(' && s.charAt(i)!=')')
                    continue;

                String newString=s.substring(0,i)+s.substring(i+1);
                if(!visited.contains(newString))
                {
                    q.add(newString);
                    visited.add(newString);
                }
            }
        }
        return result;
    }

    public static boolean isValid(String s)
    {
        int count=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                count++;
            else if(s.charAt(i)==')')
            {
                if(count==0) //If the number of ')' > number of '('
                    return false;
                else
                    count--;
            }
        }
        return count==0 ? true:false;
    }

    public static void main(String args[])
    {
        List<String> result=new ArrayList<String>();
        result=removeInvalidParentheses("(()(()");

        System.out.println("Result: "+Arrays.toString(result.toArray()));

    }
}
