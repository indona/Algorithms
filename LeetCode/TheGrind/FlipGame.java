import java.util.*;
import java.lang.*;

class FlipGame
{
    public static List<String> generatePossibleNextMoves(String s)
    {
        List<String> allNextMoves=new ArrayList<String>();

        if(s==null || s.length()<=1)
            return allNextMoves;

        //Perform a linear search and check the neighboring elements if it is a consecutive ++. If yes, flip it and add it to the resultset.
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+')
                allNextMoves.add(s.substring(0,i)+"--"+s.substring(i+2));
        }
        return allNextMoves;
    }

    public static void main(String args[])
    {
        List<String> result=new ArrayList<String>();
        result=generatePossibleNextMoves("++++");
        System.out.println("String: ++++, Possible moves: "+Arrays.toString(result.toArray()));

        result=generatePossibleNextMoves("+-+-");
        System.out.println("String: +-+-, Possible moves: "+Arrays.toString(result.toArray()));

        result=generatePossibleNextMoves("");
        System.out.println("String: \"\", Possible moves: "+Arrays.toString(result.toArray()));

        result=generatePossibleNextMoves("+-++---++-");
        System.out.println("String: +-++---++-, Possible moves: "+Arrays.toString(result.toArray()));

        result=generatePossibleNextMoves("--");
        System.out.println("String: --, Possible moves: "+Arrays.toString(result.toArray()));
    }
}
