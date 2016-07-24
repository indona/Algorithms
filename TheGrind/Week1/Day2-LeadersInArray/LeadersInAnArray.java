//Leaders In an Array: An element is a leader if it is grater than all elements to its right side.
//Complexity: Time = O(n) | Space = O(1)

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.*;

public class LeadersInAnArray
{
    static void LeadersInAnArray(int inputArray[], FileWriter writer) throws IOException
    {
        int arrLength = inputArray.length;

        if(arrLength == 0)
        {    
            writer.append("");
            return;
        }
        else if (arrLength == 1)
        {
            writer.append(inputArray[arrLength - 1]+" ");
            return;
        }
        else
        {
            int max = inputArray[arrLength-1];
            writer.append(inputArray[arrLength-1]+" ");
            for (int i=arrLength-2; i>=0; i--)
            {
                if (inputArray[i]>max)
                {
                    writer.append(inputArray[i]+" ");
                    max = inputArray[i];
                }
            }
        }
    }

    //Main function
    public static void main(String args[]) throws IOException
    {
        int T, N;
        int inputArray[];

        FileWriter writer = new FileWriter(new File("output.txt"));
        Scanner scanner = new Scanner(new FileReader("input.txt"));

        T = Integer.parseInt(scanner.next());
        for (int i=0; i<T; i++)
        {
            N = Integer.parseInt(scanner.next());
            inputArray = new int[N]; 
            for(int j=0; j<N; j++)
            {
                inputArray[j]=Integer.parseInt(scanner.next());
            }
            
            LeadersInAnArray(inputArray, writer);
            inputArray = null;
            writer.append("\n");
        }

        scanner.close();
        writer.close();
    }
}
