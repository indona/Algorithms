import java.util.*;
import java.lang.*;

public class RotateMatrix
{
    public static void rotate(int[][] matrix)
    {
        //Basic formula: i,j <-- n-1-j, i
        int n=matrix.length;
        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<Math.ceil(((double)n)/2.);j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }

    public static void main(String args[])
    {
        int[][] matrix={{1,2},{3,4}};
        rotate(matrix);
        for(int[] row: matrix)
           System.out.println(Arrays.toString(row));
    }
}
