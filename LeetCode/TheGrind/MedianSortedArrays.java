import java.util.*;

public class MedianSortedArrays
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int N1=nums1.length;
        int N2=nums2.length;

        if(N1>N2)
            return findMedianSortedArrays(nums2, nums1);

        int lo=0;
        int hi=2*N1;

        while(lo<=hi)
        {
            int C1=(lo+hi)/2; //Cutting the 2nd array
            int C2=N1+N2-C1; //Back calculate the position of the cut in the 1st array

            //Now we find the elements right before and after the cuts on both the arrays
            double L1 = (C1==0) ? Integer.MIN_VALUE : nums1[(C1-1)/2];
            double R1 = (C1==2*N1) ? Integer.MAX_VALUE : nums1[C1/2];

            double L2 = (C2==0) ? Integer.MIN_VALUE : nums2[(C2-1)/2];
            double R2 = (C2==2*N2) ? Integer.MAX_VALUE : nums2[C2/2];

            //Now we check if the cuts we have made are conforming to the requirements of sorted arrays.
            if(L1>R2)
                hi=C1-1;//This means the elements in L1 are too big than R2's contents, we need to move C1 left.
            else if(L2>R1)
                lo=C1+1;//This means that the elements in L2 are too big than R1's contents.
            else
            //This means that the cut we made is perfectly dividing the two arrays. We just need to return the combined median.
                return (Math.max(L1, L2)+Math.min(R1, R2))/2;
        }
        return -1;
    }

    public static void main(String args[])
    {
        int[] n1={1, 2};
        int[] n2={3,4};
        System.out.println("Median: "+findMedianSortedArrays(n1,n2));
    }
}
