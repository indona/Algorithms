import java.util.*;
import java.lang.*;

public class MaxProdSubArray
{
    public static int maxProduct(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int[] max=new int[nums.length];
        int[] min=new int[nums.length];

        max[0]=nums[0];
        min[0]=nums[0];
        int maxProduct=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }
            else //To handle the negative multiplication resulting in a positive number case.
            {
                max[i]=Math.max(nums[i], min[i-1]*nums[i]); //Multiplying a negative with min => positive
                min[i]=Math.min(nums[i], max[i-1]*nums[i]); //+ve * -ve => -ve
            }
            maxProduct=Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }

    public static void main(String args[])
    {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max product: "+maxProduct(nums));
    }
}
