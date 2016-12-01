import java.util.*;

class SearchFirstOfK
{
    public static void searchFirstOfK(int[] inputArray, int key)
    {
        int start=0;
        int end=inputArray.length-1;
        int index=-1;

        while(start<=end)
        {
            int mid=(start+end)/2;
            if(inputArray[mid]==key)
            {
                index=mid;
                end=mid-1;
            }
            else if (inputArray[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        System.out.println(index+"\n");
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        int T=scanner.nextInt();

        for(int i=0;i<T;i++)
        {
            int N=scanner.nextInt();
            int[] inputArray=new int[N];
            for(int j=0;j<N;j++)
            {
                inputArray[j]=scanner.nextInt();
            }
            int key=scanner.nextInt();
            searchFirstOfK(inputArray, key);
        }
    }
}
