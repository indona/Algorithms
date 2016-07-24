//Day11 Problem: Merge an array of size n into another array of size m+n
//Input: Array with m+n elements.
//Value "0" => Value is not filled/available in array with m+n elements. There should be n such array blocks.
//Input: array with n elements (N[]). 
//Output: N[] merged into mPlusN[] (Final array must be sorted)
//Complexity: Time=O(m+n) | Space=O(1)

import java.util.Scanner;
import java.util.Arrays;

public class MergeAnArrayIntoAnother
{
    public static int[] mergeAnArrayIntoAnother(int inputArray1[], int inputArray2[], int length1, int length2)
    {
        int i=length1-1, j=length1-1;
        while(i>=0)
        {
            if(inputArray1[i]!=0)
            {
                inputArray1[j]=inputArray1[i];
                i--; j--;
            }
            else
                i--;
        }


        //j: Pointer to the first element in Array1, i:Pointer to the first element in Array2
        int k=0;
        i=0; j=length2;
        while(k<length1)
        {
            if((i==length2) || ( j<length1 && inputArray1[j]<=inputArray2[i]))
            {
                inputArray1[k]=inputArray1[j];
                k++;j++;
            }
            else
            {
                inputArray1[k]=inputArray2[i];
                k++;i++;
            }
        }
        return inputArray1;
    }
    public static void main(String args[])
    {
        int T, M, N;
        int inputArray1[], inputArray2[];

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();

        for(int i=0;i<T;i++)
        {
            M=scanner.nextInt();
            inputArray1=new int[M];
            for(int j=0;j<M;j++)
            {   
                inputArray1[j]=scanner.nextInt();
            }

            N=scanner.nextInt();
            inputArray2=new int[N];
            for(int j=0;j<N;j++)
            {
                inputArray2[j]=scanner.nextInt();
            }

            inputArray1 = mergeAnArrayIntoAnother(inputArray1, inputArray2, M, N);
            System.out.println(Arrays.toString(inputArray1));
        }
        scanner.close();
    }
}
