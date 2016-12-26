import java.lang.*;
import java.util.*;

class NumberOfSteps
{
    public static int calculateNumberOfSteps(int n, int k)
    {
        return _calculateNumberOfSteps(n, k, new int[n+1]);
    }

    public static int _calculateNumberOfSteps(int step, int k, int[] dpTable)
    {
        if(step<=1)
            return 1;
        if(dpTable[step]==0)
        {
            for(int i=1;i<=k && step-i>=0;i++)
            {
                dpTable[step]+=_calculateNumberOfSteps(step-i, k, dpTable);
            }
        }
        return dpTable[step];
    }

    public static void main(String args[])
    {
        int ways=calculateNumberOfSteps(4,2);
        System.out.println("For n=4 and k=2, ways: "+ways);

        ways=calculateNumberOfSteps(5,3);
        System.out.println("For n=5 and k=3, ways: "+ways);
    }
}
