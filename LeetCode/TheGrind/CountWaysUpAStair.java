import java.util.*;

public class CountWaysUpAStair
{
    public static int climbStairs(int n)
    {
        //DP problem
        //For say no of allowed steps=3, possible last steps: 1 step, 2 step or 3 steps (BASE CASES)
        //So, #n=#(n-1) + #(n-2) + #(n-3)

        int[] dpTable=new int[n+1];
        Arrays.fill(dpTable, -1);
        return _climbStairs(n, dpTable);
    }

    public static int _climbStairs(int n, int[] dpTable)
    {
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        else if(dpTable[n]!=-1)
            return dpTable[n];
        else
        {
            dpTable[n]=_climbStairs(n-1, dpTable)+_climbStairs(n-2, dpTable)+_climbStairs(n-3, dpTable);
            return dpTable[n];
        }
    }

    public static void main(String args[])
    {
        System.out.println("Ways: "+climbStairs(5));
    }
}
