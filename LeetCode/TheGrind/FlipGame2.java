import java.util.*;
import java.lang.*;

public class FlipGame2
{
    public static boolean canWin(String s)
    {
        //Sanity
        if(s==null || s.length()<=1)
            return false;

        //To solve this problem, we need to consider all possible moves and its subsequent moves by both the players.
        //To avoid recomputations, we use a DP table to store precomputed results which can be directly used.
        HashMap<String, Boolean> dpTable=new HashMap<String, Boolean>();
        return _canWin(s, dpTable);
    }

    public static boolean _canWin(String move, HashMap<String, Boolean> dpTable)
    {
        if(dpTable.containsKey(move))
            return dpTable.get(move);

        for(int i=0;i<move.length()-1;i++)
        {
            //Find the first possible ++ in the given board condition. FLip it to -- and recurse to find the possibility of win for the other player. If the next player cannot win i.e. returns a false, your move is successfull and hence update the DP Table to true.
            if(move.startsWith("++", i))
            {
                String nextMove=move.substring(0,i)+"--"+move.substring(i+2);
                if(!_canWin(nextMove, dpTable))
                {
                    dpTable.put(move, true);
                    return true;
                }
            }
        }
        dpTable.put(move, false);
        return false;
    }

    public static void main(String args[])
    {
        boolean result=canWin("++---+-++-++");
        System.out.println("String: ++---+-++-++, Result: "+result);

        result=canWin("+++++++");
        System.out.println("String: +++++++, Result: "+result);

        result=canWin("++++");
        System.out.println("String: ++++, Result: "+result);
    }
}
