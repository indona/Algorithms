//Day8 Problem: Find the Missing Number
//You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list.
//Complexity: Time=O(N) | Space=O(1)

import java.util.Scanner;

public class MissingNumber
{
    public static void missingNumber(int inputArray[])
    {
        int arrayXor =0, completeXor =0;
        for (int i=0; i<inputArray.length; i++)
            arrayXor = arrayXor ^ inputArray[i];

        for(int i=inputArray[inputArray.length - 1]; i>0; i--)
            completeXor = completeXor ^ i;

        System.out.println(arrayXor ^ completeXor);
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

            missingNumber(inputArray);
        }
    }
}
