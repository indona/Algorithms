import java.lang.*;
import java.util.*;

class RegExMatching
{
    public static boolean isMatch(String s, String p)
    {
        //Sanity
        if(s==null || p==null)
            return false;
        if(p.length()!=0 && p.charAt(0)=='*')
            return false;

        boolean[][] dpTable=new boolean[s.length()+1][p.length()+1];
        //for(boolean[] row: dpTable)
        //    Arrays.fill(row, false);
        dpTable[0][0]=true;

        for(int i=0;i<p.length();i++)
        {
            if(p.charAt(i)=='*')
                dpTable[0][i+1]=dpTable[0][i-1];
        }

        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<p.length();j++)
            {
                //If current character is a "." i.e. this element does not need to be matched explicitly. Fill according to the previous DP table entry.
                if(p.charAt(j)=='.')
                    dpTable[i+1][j+1]=dpTable[i][j];

                //If the characters in P and S match, fill based on the previous DP Table entry.
                if(p.charAt(j)==s.charAt(i))
                    dpTable[i+1][j+1]=dpTable[i][j];

                //If the current character is a "*", there are two options:
                if(p.charAt(j)=='*')
                {
                    //1. If the previous charaters of P and current at S don't match (AND previous P was not a .), then fill according to previous entry.
                    if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.')
                        dpTable[i+1][j+1]=dpTable[i+1][j-1];
                    //2. If the previous character of P and current S matches or if the previous P is a ".", the there are three options:
                    //x* : denotes multiple x's (dpTable[i+1][j+1]=dpTable[i][j+1])
                    //x* : denotes single x (dpTable[i+1][j+1]=dpTable[i+1][j])
                    //x* : denotes 0 x (DpTable[i+1][j+1]=dpTable[i+1][j-1])
                    else
                        dpTable[i+1][j+1]=(dpTable[i][j+1] || dpTable[i+1][j] || dpTable[i+1][j-1]);
                }
            }
        }

        return dpTable[s.length()][p.length()];
    }

    public static void main(String args[])
    {
        System.out.println("S: aab, P: c*a*b Status: "+isMatch("aab", "c*a*b"));
    }
}
