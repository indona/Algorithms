import java.util.*;

class BinarySearch
{
    public static void binarySearch(int[] inputArray, int key)
    {  
        int start=0;
        int end=inputArray.length-1;
        while(start<=end)
        {
            int mid=(end+start)/2;

            if(inputArray[mid]==key)
            {
                System.out.println(mid+"\n");
                return;
            }
            else if (inputArray[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        System.out.println(-1+"\n");
        return;
    }

    public static void main(String args[])
    {
        int[] inputArray;

        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();

        for(int i=0;i<T;i++)
        {
            int N=scanner.nextInt();
            inputArray=new int[N];
            for(int j=0;j<N;j++)
            {
                inputArray[j]=scanner.nextInt();
            }
            int key=scanner.nextInt();
            binarySearch(inputArray, key);
        }
    }
}
