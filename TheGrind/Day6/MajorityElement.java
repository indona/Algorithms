//Problem: Find the Majority Element in a given array.
//A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
//Complexity: Time=O(N) | Space=O(1)

import java.util.Scanner;

class MajorityElement
{
    public static int findMajorityCandidate(int inputArray[])
    {
        int majorityIndex = 0;
        int count = 1;

        for(int i=1; i<inputArray.length; i++)
        {
            if(inputArray[majorityIndex] == inputArray[i])
                count++;
            else
                count--;

            if(count == 0)
            {
                majorityIndex = i;
                count = 1;
            }
        }
        return inputArray[majorityIndex];
    }

    public static void confirmMajority(int majorityCandidate, int inputArray[])
    {
        int count=0;
        for (int i=0; i<inputArray.length; i++)
        {
            if(inputArray[i] == majorityCandidate)
                count++;
        }

        if(count > inputArray.length/2)
            System.out.println(majorityCandidate);
        else
            System.out.println("N/A");
    }

    public static void main(String args[])
    {
        int T, N, majorityCandidate;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N = scanner.nextInt();
            inputArray = new int[N];
            for(int j=0; j<N; j++)
                inputArray[j] = scanner.nextInt();
            
            majorityCandidate = findMajorityCandidate(inputArray);
            confirmMajority(majorityCandidate, inputArray);
        }
    }
}
