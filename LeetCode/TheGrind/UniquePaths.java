public class UniquePaths 
{
    public static int uniquePaths(int m, int n)
    {
        if ((m==0 && n==0) || (m==1) || (n==1))
            return 1;

        int[][] dpTable=new int[m][n];

        //Fill the left col with 1s - as there is just one way to reach these cells - go down.
        for(int i=0;i<m;i++)
            dpTable[i][0]=1;

        //Fill the top row with 1s - as there is just one way to reach these cells - move right.
        for(int i=0;i<n;i++)
            dpTable[0][i]=1;

        //For every other cell, the way of coming to that cell depends on the number of ways to reach the left cell and the cell above it
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
                dpTable[i][j]=dpTable[i-1][j]+dpTable[i][j-1];
        }
        return dpTable[m-1][n-1];
    }

    public static void main(String args[])
    {
        System.out.println("Number of ways: "+uniquePaths(1, 11));
        System.out.println("Number of ways: "+uniquePaths(11, 11));
        System.out.println("Number of ways: "+uniquePaths(2, 11));

    }
}
