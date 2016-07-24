//Problem: Search an element in a sorted array rotated around a pivot. If present return the element index else N/A.
//In case of dulplicates, any one of the element is picked for result.
//Complexity: Time=O(log N) | Space=O(1)

import java.util.Scanner;

public class PivotedBinarySearch
{
    public static void pivotedBinarySearch(int inputArray[], int start, int end, int findElement)
    {
        int mid = (start+end)/2;

        if(start <= end)
        {
            if (inputArray[mid] == findElement)
            {
                System.out.println(mid);
                return;
            }
            else if (inputArray[start] < inputArray[mid]) //Pivot not in left subarray - i.e. LHS sorted
            {
                if(findElement <= inputArray[mid] && findElement >= inputArray[start]) //Required element is in the Left subarray
                    pivotedBinarySearch(inputArray, start, mid-1, findElement);
                else
                    pivotedBinarySearch(inputArray, mid+1, end, findElement); //Required element is in Right subarray
            }
            else //pivot not in right subarray - RHS sorted
            {
                if(findElement >= inputArray[mid] && findElement <= inputArray[end]) //Required element is in Right subarray
                    pivotedBinarySearch(inputArray, mid+1, end, findElement);
                else
                    pivotedBinarySearch(inputArray, start, mid-1, findElement); //Required element in Left subarray
            }
        }
        else
        {
            System.out.println("N/A");
            return;
        }
    }

    public static void main(String args[])
    {
        int T, N, findElement;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);

        T=scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N=scanner.nextInt();
            inputArray= new int[N];
            for(int j=0; j<N; j++)
            {
                inputArray[j] = scanner.nextInt();
            }

            findElement = scanner.nextInt();
            pivotedBinarySearch(inputArray, 0, N-1, findElement);
        }
        scanner.close();
    }
}
