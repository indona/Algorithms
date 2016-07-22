class GenericElement implements Comparable<GenericElement>
{
    T member1;
    V member2;

    GenericElement(T parameter1, V parameter2)
    {
        member1 = parameter1;
        member2 = parameter2;
    }

    T getValue()
    {
        return member1;
    }

    V getValue()
    {
        return member2;
    }
}

public class BinarySearch
{
    public <T extends Comparable<T>> int binarySearch(T inputArray[], T findElement)
    {
        int start = 0;
        int end = inputArray.length;
        if (end >= start)
        {
            int mid = (start+end)/2;
            if(findElement.compareTo(inputArray[mid]) == 0)                              //Element found
                return mid;
            else if (findElement.compareTo(inputArray[mid] < 0))                         //Search Left subarray
                return binarySearch(inputArray, start, mid-1, findElement);
            else                                                                         //Search right subarray
                return binarySearch(inputArray, mid+1, end, findElement);
        }
        else
            return -1;
    }

    public static void main(String args[])
    {
        GenericElement inputArray[];;
        GenericElement findElement = new GenericElement();

        int T, N;
        int inputArray[];

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for(int i=0; i<T; i++)
        {
            N = scanner.nextInt();
            inputArray = new GenericElement[N];
            for(int j=0; j<(2*N+1); j++)
            {
                inputArray[j] = scanner.nextInt();
            }
            SegregateArray(inputArray);
        }
        scanner.close();
    }
}
