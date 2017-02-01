import java.util.*;

public class SparseMultiply
{
    public static int[][] multiply(int[][] A, int[][] B)
    {
        int x=A.length;
        int y=A[0].length;
        int z=B[0].length;

        int[][] C=new int[x][z];

        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                if(A[i][j]!=0)
                {
                    for(int k=0;k<z;k++)
                        C[i][k]+=A[i][j]*B[j][k];
                }
            }
        }
        return C;
    }

    public static void main(String args[])
    {
        int[][] A = {{1,0,0},{-1,0,3}};
        int[][] B ={{7,0,0},{0,0,0},{0,0,1}};
        int [][] C = multiply(A, B);

        for(int[] row: C)
            System.out.println(Arrays.toString(row));
    }
}
