//Problem: Median of two sorted arrays
//There are 2 sorted arrays A and B of size n each. 
//Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n).
//Complexity: Time=O(log N) | Space=O(1)

import java.util.Scanner;
import java.lang.Math;

public class MedianOfTwoArrays
{
    public static int medianOfTwoArrays(int inputArray1[], int inputArray2[], int start1, int end1, int start2, int end2)
    {
        int median1, median2;
        int length = end1-start1+1;

        if(length==1)
            return (inputArray1[0]+inputArray2[0])/2;
        else if (length==2)
        {
            int a = Math.max(inputArray1[start1],inputArray2[start2]);
            int b = Math.min(inputArray1[end1], inputArray2[end2]);
            return (a+b)/2;
            //return (Math.max(inputArray1[start1],inputArray2[start2]) + Math.min(inputArray1[end1], inputArray2[end2])/2);
        }
        else if (length>2)
        {
            //Get medians
            if(length%2 == 0)
            {
                median1=(inputArray1[(start1+length/2)-1]+inputArray1[start1+length/2])/2;        
                median2=(inputArray2[(start2+length/2)-1]+inputArray2[start2+length/2])/2;
            }
            else
            {
                median1=inputArray1[start1+length/2];
                median2=inputArray2[start2+length/2];
            }

            if(median1==median2)
                return median1;
            else if(median1<median2)
            {
                if(length%2 == 0)
                    return medianOfTwoArrays(inputArray1, inputArray2, start1+length/2, end1, start2, start2+length/2-1);
                else
                    return medianOfTwoArrays(inputArray1, inputArray2, start1+length/2, end1, start2, start2+length/2);
            }
            else //Median1>Median2
            {
                if(length%2 == 0)
                    return medianOfTwoArrays(inputArray1, inputArray2, start1, start1+length/2-1, start2+length/2, end2);
                else
                    return medianOfTwoArrays(inputArray1, inputArray2, start1, start1+length/2, start2+length/2, end2);
            }
        }
        else
            return -1;
    }

    public static void main (String args[])
    {
        int T, N, median;
        int inputArray1[], inputArray2[];

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N=scanner.nextInt();
            inputArray1 = new int[N];
            inputArray2 = new int[N];

            for(int j=0; j<N; j++)
                inputArray1[j]=scanner.nextInt();

            for(int j=0; j<N; j++)
                inputArray2[j]=scanner.nextInt();

            median = medianOfTwoArrays(inputArray1, inputArray2, 0, N-1, 0, N-1);
            System.out.println(median);
        }
        scanner.close();
    }
}
