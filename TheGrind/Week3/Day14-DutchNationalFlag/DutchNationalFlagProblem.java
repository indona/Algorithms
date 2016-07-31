//Day14 Problem: Dutch national Flag Problem
//Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
//Complexity: Time=O(N) | Space=O(1)

import java.util.Scanner;
import java.util.Arrays;

public class DutchNationalFlagProblem
{
    public static int[] sort(int inputArray[])
    {
        int low=0, mid=0;
        int high=inputArray.length-1;

        while(mid<=high)
        {
            if(inputArray[mid]==0) //Swap Low and Mid and increment both
            {
                if(inputArray[low]!=inputArray[mid])
                {
                    int temp=inputArray[mid];
                    inputArray[mid]=inputArray[low];
                    inputArray[low]=temp;
                }
                low++;
                mid++;
            }
            else if (inputArray[mid]==1) //No swap. Mid incremented.
                mid++;
            else //Swap Mid and High and decrement high.
            {
                if(inputArray[mid]!=inputArray[high])
                {
                    int temp=inputArray[mid];
                    inputArray[mid]=inputArray[high];
                    inputArray[high]=temp;
                }
                high--;
            }
        }
        return inputArray;
    }

    public static void main(String args[])
    {
        int T, N;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N=scanner.nextInt();
            inputArray=new int[N];

            for(int j=0; j<N; j++)
                inputArray[j]=scanner.nextInt();

            inputArray=sort(inputArray);
            System.out.println(Arrays.toString(inputArray));
        }
    }
}
