import java.util.*;

public class MaxSlidingWindow
{
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        if(nums==null || k<1)
            return new int[0];
        else if(k==1)
            return nums;

        int n=nums.length;
        int[] result=new int[n-k+1];
        int resultIndex=0;

        Deque<Integer> dq=new LinkedList<Integer>();

        for(int i=0;i<n;i++)
        {
            //Our aim is to keep the deque's size trimmed to K. That's why we insert indices into the deque instead of elements.
            //Before inserting any index into the deque, we check if the deque's head is out of the window size.
            //If the deque's head > i-k => the head is out of window size. We poll the head out.
            if(!dq.isEmpty() && dq.peekFirst()==i-k)
                dq.poll();

            //We also don't keep redundant values in the deque. If our current index has value greater than the dq's elements, we poll them out from the end till we enounter a number bigger than the current or the deque is empty.
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()])
                dq.removeLast();

            //Now add the current index to the queue.
            dq.add(i);

            //If we have an active window, store the maximum in the result array.
            if(i>=k-1)
                result[resultIndex++]=nums[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String args[])
    {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println("Sliding window maximum: "+Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
