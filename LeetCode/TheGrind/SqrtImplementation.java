public class SqrtImplementation
{
    public static int mySqrt(int x) 
    {
        /*
        //Newton's Method:
        long t=x;
        while(t*t>x)
        {
            t=(t+(x/t))/2;
        }
        return (int) t;
        */

        //Binary Search:
        if(x==1 || x==0)
            return x;

        int left=1, right=Integer.MAX_VALUE;
        while(true)
        {
            int mid=left+(right-left)/2;
            if(mid>x/mid)
                right=mid-1;
            else
            {
                if(mid+1>x/(mid+1))
                    return mid;
                else
                    left=mid+1;
            }
        }
    }
    public static void main(String args[])
    {
        System.out.println("Sqrt of 110: "+mySqrt(110));
        System.out.println("Sqrt of 0: "+mySqrt(0));
        System.out.println("Sqrt of 2310: "+mySqrt(2310));
    }
}
