public class PaintFence
{
    public static int numWays(int n, int k)
    {
        if(n==0)
            return 0;
        if(n==1)
            return k;

        //Fence 1 : k ways (always)
        //Fence 2 : i)If it is painted as the previous fence = k
        //          ii)If it is painted different = k*(k-1)
        int sameColor=k;
        int diffColor=k*(k-1);

        for(int i=2;i<n;i++)
        {
            //The way you can paint the 3rd fence:
            //i) If the previous fences are painted same, F3 has to be painted differently => same*(k-1) //Different F2 and F3
            //ii) If the previous fences are painted different, F3 can be painted same as F2 or different =>
            //    - Paint F3 same as F2 => diffColor*1 //Same F2 and F3
            //    - Paint F3 different from F2 => diffColor*(k-1) //Different F2 and F3
            //Combine the different's and same's

            int temp=diffColor;
            diffColor=sameColor*(k-1) + diffColor*(k-1);
            sameColor=diffColor;
        }
        return diffColor+sameColor;
    }

    public static void main(String args[])
    {
        System.out.println("Number of ways: "+numWays(10, 5));
    }
}
