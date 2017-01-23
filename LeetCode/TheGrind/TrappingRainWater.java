import java.lang.*;
import java.util.*;

class TrappingRainWater
{
    public static int trap(int[] height)
    {
        if (height.length==0 || height==null)
            return 0;

        //Idea is to scan from both ends and store the max height for that particular index from both ends. The minimum of the two tells you the volume for that cell
        int[] left=new int[height.length];
        int[] right=new int[height.length];

        //Scan from left
        int max=height[0];
        for(int i=0;i<height.length;i++)
        {
            if(height[i]>max)
                max=height[i];

            left[i]=max;
        }
        System.out.println(Arrays.toString(left));

        //Scan from right
        max=height[height.length-1];
        for(int i=height.length-1;i>=0;i--)
        {
            if(height[i]>max)
                max=height[i];

            right[i]=max;
        }
        System.out.println(Arrays.toString(right));


        //Calculate the volume (Minimum of left and right) and count the water that can be trapped i.e. Volume - height
        int water=0, volume=0;
        for(int i=0;i<height.length;i++)
        {
            volume=Math.min(left[i], right[i]);
            water+=volume-height[i];
            System.out.println(i+" "+volume+" "+water);

        }
        return water;
    }

    public static void main(String args[])
    {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped water volume: "+trap(height));
    }
}
