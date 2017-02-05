public class UniquePaths2
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if (m==1 && n==1)
            return (obstacleGrid[0][0]==0 ? 1:0);

        int[][] dpTable=new int[m][n];

        //Fill the left col with 1s - as there is just one way to reach these cells - go down.
        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0]!=1)
                dpTable[i][0]=1;
            else
                break;
        }

        //Fill the top row with 1s - as there is just one way to reach these cells - move right.
        for(int i=0;i<n;i++)
        {
            if(obstacleGrid[0][i]!=1)
                dpTable[0][i]=1;
            else
                break;
        }

        //For every other cell, the way of coming to that cell depends on the number of ways to reach the left cell and the cell above it
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]!=1)
                    dpTable[i][j]=dpTable[i-1][j]+dpTable[i][j-1];
            }
        }
        return dpTable[m-1][n-1];
    }

    public static void main(String args[])
    {
        int[][] matrix={
        {0,0,0},
        {0,0,0},
        {0,0,0}};

        int[][] matrix1={
            {0}};

        int[][] matrix2={
            {1}};

        int[][] matrix3={
            {0,0,1},
            {1,0,1},
            {0,0,1}};

        // System.out.println("Number of ways: "+uniquePathsWithObstacles(matrix));
        // System.out.println("Number of ways: "+uniquePathsWithObstacles(matrix1));
        // System.out.println("Number of ways: "+uniquePathsWithObstacles(matrix2));
        System.out.println("Number of ways: "+uniquePathsWithObstacles(matrix3));

    }
}
