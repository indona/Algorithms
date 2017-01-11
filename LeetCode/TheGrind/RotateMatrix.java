import java.util.*;
import java.lang.*;

public class RotateMatrix
{
    //Rotating a matrix is equivalent to:
    //1. Transpose
    //2. Swapping of rows/ columns depending on the direction of rotation.
    //For clockwise: Transpose + Column swap
    //For Anti-clockwise: Transpose + Row swap

    public static void rotateClockwise(int[][] matrix)
    {
        //Transpose
        transpose(matrix);

        //Swap columns (Left-Right swap)
        int n=matrix.length;
        for(int i=0;i<n;i++) //all rows
        {
            for(int j=0;j<n/2;j++) //half cols
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }

    public static void rotateAntiClockwise(int[][] matrix)
    {
        //Transpose
        transpose(matrix);

        //Swap rows (Top-Bottom swap)
        int n=matrix.length;
        for(int i=0;i<n/2;i++) //half rows
        {
            for(int j=0;j<n;j++) //all cols
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;
            }
        }
    }

    public static void transpose(int[][] matrix)
    {
        //Only elements above the diagonal are swapped
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void main(String args[])
    {
        int[][] matrix={{1,2},{3,4}};
        System.out.println("Before");
        for(int[] row: matrix)
           System.out.println(Arrays.toString(row));

        rotateClockwise(matrix);
        System.out.println("After clockwise");
        for(int[] row: matrix)
           System.out.println(Arrays.toString(row));


        int[][] matrix2={{1,2},{3,4}};
        System.out.println("\nBefore");
        for(int[] row: matrix2)
            System.out.println(Arrays.toString(row));

        System.out.println("After Anti-clockwise");
        rotateAntiClockwise(matrix2);
        for(int[] row: matrix2)
            System.out.println(Arrays.toString(row));
    }
}
