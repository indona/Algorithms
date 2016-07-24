//Segregate 0s and 1s in an Array: You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array.
//Comlplexity: Time=O(N) | Space=O(1)

import java.util.Scanner;
import java.util.Arrays;

public class SegregateArray
{
    static void SegregateArray(int inputArray[])
    {
        int leftPtr = 0;
        int rightPtr = inputArray.length - 1;

        while(rightPtr>leftPtr)
        {
            while(rightPtr>leftPtr && inputArray[leftPtr] == 0) //Move forward til you encounter the first 1
                leftPtr++;

            while(rightPtr>leftPtr && inputArray[rightPtr]==1) //Move backward till you enounter the first 0
                rightPtr--;
            
            //leftptr and rightPtr now aligned with respect to a mismatch
            if(rightPtr>leftPtr)
            {
                int temp = inputArray[leftPtr];
                inputArray[leftPtr] = inputArray[rightPtr];
                inputArray[rightPtr] = temp;
                leftPtr++;
                rightPtr--;
            }
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void main(String args[])
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
                inputArray[j] = scanner.nextInt();

            SegregateArray(inputArray);
        }
        scanner.close();
    }
}
