import java.lang.*;
import java.util.*;

public class ProductExceptSelf
{
    public static int[] productExceptSelf(int[] nums)
    {
        if(nums.length==0)
            return null;

        int[] result=new int[nums.length];
        int[] t1=new int[nums.length];
        int[] t2=new int[nums.length];

        t1[0]=1;
        for(int i=1;i<t1.length;i++)
        {
            t1[i]=t1[i-1]*nums[i-1];
        }
        System.out.println("T1: "+Arrays.toString(t1));

        t2[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            t2[i]=t2[i+1]*nums[i+1];
        }
        System.out.println("T2: "+Arrays.toString(t2));

        for(int i=0;i<nums.length;i++)
        {
            System.out.println("T1i: "+t1[i]+" T2i: "+t2[i]+"Result: "+result[i]);
            result[i]=t1[i]*t2[i];
        }
        System.out.println("Result: "+Arrays.toString(result));
        return result;
    }

    public static void main(String args[])
    {
        int[] nums={1,0};
        int[] result=productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
