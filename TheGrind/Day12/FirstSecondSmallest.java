//Day12 Problem: Find the smallest and second smallest element in an array
//Complexity: Time=O(N) | Space=O(1)

import java.util.Scanner;

public class FirstSecondSmallest
{
    public static void firstSecondSmallest(int inputArray[])
    {
        int min, secondMin;
        int length=inputArray.length;
        if(length<2)
            System.out.println("Input Invalid");
        else
        {
            if(inputArray[0]<=inputArray[1])
            { 
                min=inputArray[0];
                secondMin=inputArray[1];
            }
            else
            {
                min=inputArray[1];
                secondMin=inputArray[0];
            }

            for(int i=2;i<length;i++)
            {
                if(inputArray[i]<=min)
                {
                    secondMin=min;
                    min=inputArray[i];
                }
                else
                {
                    if(inputArray[i]<=secondMin)
                        secondMin=inputArray[i];
                }
            }
            System.out.println("Min: "+min+", SecondMin: "+secondMin);
        }

    }

    public static void main(String args[])
    {
        int T,N;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N=scanner.nextInt();
            inputArray=new int[N];

            for(int j=0; j<N; j++)
                inputArray[j]=scanner.nextInt();

            firstSecondSmallest(inputArray);
        }
        scanner.close();
    }
}
