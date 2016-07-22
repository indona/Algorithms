//Problem Day7: Largest Sum Contiguous Subarray.Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
//Works for negative arrays too.
//Complexity: Time=O(N) | Space=O(1)

import java.util.Scanner;

public class LargestSumSubArray
{
    public static void largestSumSubArray(int inputArray[])
    {
        int currentMaxSum = 0, newMaxSum = 0;
        int largestElement = inputArray[0];

        for(int i=0; i<inputArray.length; i++)
        {
            newMaxSum = newMaxSum + inputArray[i];

            if(newMaxSum < 0)
                newMaxSum = 0;

            if(currentMaxSum < newMaxSum)
                currentMaxSum = newMaxSum;

            if(largestElement < inputArray[i])
                largestElement = inputArray[i];
        }

        if(largestElement < 0)
            System.out.println(largestElement);
        else
            System.out.println(currentMaxSum);
    }

    public static void main (String args[])
    {
        int T, N;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N = scanner.nextInt();
            inputArray = new int[N];
            for(int j=0; j<N; j++)
            {
                inputArray[j] = scanner.nextInt();
            }

            largestSumSubArray(inputArray);
        }

        scanner.close();
    }
}
