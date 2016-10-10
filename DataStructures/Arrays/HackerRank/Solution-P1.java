import java.io.*;
import java.util.*;

public class Solution-P1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int N, sum, max=-63;
        int[][] inputArray;
        String line;
        String[] tempArray;

        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        tempArray = line.split(" ");
        N=tempArray.length;
        inputArray = new int[N][N];

        for(int i=0; i<N; i++)
            inputArray[0][i] = Integer.parseInt(tempArray[i]);
 
        for(int i=1;i<N;i++)
        {
            tempArray=scanner.nextLine().split(" ");
            for(int j=0;j<N;j++)
                inputArray[i][j]=Integer.parseInt(tempArray[j]);
        }

       /* for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                inputArray[i][j]=scanner.nextInt();
            }
        }

        for (int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                System.out.print(inputArray[i][j]+"  ");
            }
            System.out.println();
        }*/

        for(int i=0;i<N-2;i++) {
            for (int j=0;j<N-2; j++) {
                sum=inputArray[i][j]+inputArray[i][j+1]+inputArray[i][j+2]+inputArray[i+1][j+1]+inputArray[i+2][j]+inputArray[i+2][j+1]+inputArray[i+2][j+2];
                System.out.println("Sum: "+sum);
                if(sum>max) {
                    max=sum;
                }
            }
        }

        System.out.println(max);
    }
}

