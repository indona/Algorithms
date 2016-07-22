//Binary Search : Using recursion
//Complexity: Time = O(log n), Space = O(1)

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;


class BinarySearch
{
    static int binarySearch(int givenArray[], int start, int end, int findElement)
    {
        if(end >= start)
        {
            int mid = (start+end)/2;
            if(givenArray[mid] == findElement)                              //Element found
                return mid;
            else if (givenArray[mid] > findElement)                         //Search Left subarray
                return binarySearch(givenArray, start, mid-1, findElement);
            else                                                            //Search right subarray
                return binarySearch(givenArray, mid+1, end, findElement); 
        }
        else
            return -1;                                                      //Element not found
    }

    public static void main(String args[]) throws IOException
    {
        int T, N, findElement, result;
        int givenArray[];

        FileWriter output = new FileWriter(new File("output.txt"));
        Scanner input = new Scanner(new FileReader ("input.txt"));
        T = Integer.parseInt(input.next());

        for (int i=0; i<T; i++)
        {
            N = Integer.parseInt(input.next());
            givenArray = new int[N];
         
            for(int j=0; j<N; j++)
            {
                givenArray[j] = Integer.parseInt(input.next());
            }

            findElement = Integer.parseInt(input.next());
            result = binarySearch(givenArray, 0, givenArray.length-1, findElement);
            givenArray = null;
            output.append(result+ "\n");
        }
        input.close();
        output.close();
    }
}
