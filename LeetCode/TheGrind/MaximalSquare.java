import java.lang.*;
import java.util.*;

public class MaximalSquare
{
    public static int maximalSquare(char[][] matrix)
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int result=0;
        int rows=matrix.length;
        int cols=matrix[0].length;

        /*
        //Solution 1: With a m*n DP Table which keeps track of the maximum square possible at each cell
        int[][] dpTable=new int[rows+1][cols+1];
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dpTable[i][j]=Math.min(dpTable[i][j-1], Math.min(dpTable[i-1][j-1], dpTable[i-1][j]))+1;
                    result=Math.max(result, dpTable[i][j]);
                }
            }
        }
        */

        //Solution 2: With a DP array keeping track of only the relevant cells for caculating the current max.
        int[] dp=new int[cols+1];
        int previous=0;
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1')
                {
                    dp[j]=Math.min(previous, Math.min(dp[j-1], dp[j]))+1;
                    result=Math.max(result, dp[j]);
                }
                else
                    dp[j]=0;
                previous=temp;
            }
        }

        return result*result;
    }

    public static void main(String args[])
    {
        char[][] matrix={{'1','0','1','0'},{'1','0','1','1'},{'1','0','1','1'},{'1','1','1','1'}};
        System.out.println("Max square size: "+maximalSquare(matrix));
    }
}
