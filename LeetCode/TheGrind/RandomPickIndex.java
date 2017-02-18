import java.util.*;

public class RandomPickIndex
{
    int[] nums;
    Random rand;

    public RandomPickIndex(int[] nums)
    {
        this.nums=nums;
        rand=new Random();
    }

    public int pick(int target)
    {
        //The logic behind this problem is the concept of Reservoir sampling. We have a target number in mind, for which we need to return its right indices at random.
        //We scan through the list. If the current number doesn't match the target, then continue.
        //Else we increment a count - which dentes the number of occurences of target in the array so far.
        //We generate a random number between 0 and count [0 to (count-1)]. We observe the probability of getting a 0 (rather - probability that we'll have to change the last picked number) in this step. => This is the actual randomize part.
        //1st occurrence: P=1 (Only 1 item)
        //2nd: P=1/2 (P that we'll have to swap to the new item)
        //3rd: P=2/3 (P of getting the new number=1/3, or keeping the old number=2/3)
        //During this process, whenever we find a 0, we update the index to be reported in result.
        //At the end, the final probabilities accumulate as: 1* 1/2 * 2/3 => 1/3

        int count=0, result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=target)
                continue;

            count++;
            if(rand.nextInt(count)==0)
            {
                result=i;
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        int[] nums={1,2,3,3,3};
        RandomPickIndex obj = new RandomPickIndex(nums);
        int ans = obj.pick(3);
        System.out.println("Answer: "+ans);
    }
}
