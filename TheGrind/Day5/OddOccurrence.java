//Day 5 Problem: Find the Number Occurring Odd Number of Times
//Complexity: Time=O(n) | Space=O(1)


import java.util.Scanner;

public class OddOccurrence
{
    public static void findOddOccurrence(int inputArray[])
    {
        int oddOccurrence = 0;
        for(int i=0; i<inputArray.length; i++)
        {
            oddOccurrence = oddOccurrence ^ inputArray[i];

        }

        System.out.println(oddOccurrence);
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
            {
                inputArray[j]=scanner.nextInt();
            }
            findOddOccurrence(inputArray);
        }
        scanner.close();
    }
}
