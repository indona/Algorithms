import java.lang.*;
import java.util.*;

public class MaxRectangleHistogram
{
    public static int largestRectangleArea(int[] heights)
    {
        if (heights==null || heights.length==0)
            return 0;

        Stack<Integer> stack=new Stack<Integer>();

        int i=0, maxArea=0;
        while(i<heights.length)
        {
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()])
            {
                stack.push(i);
                i++;
            }
            else
            {
                int index=stack.pop();
                int height=heights[index];
                int width=stack.isEmpty() ? i:i-stack.peek()-1;
                int area=height*width;
                maxArea=Math.max(maxArea, area);
            }
        }

        while(!stack.isEmpty())
        {
            int index=stack.pop();
            int height=heights[index];
            int width=stack.isEmpty() ? i:i-stack.peek()-1;
            int area=height*width;
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String args[])
    {
        int[] heights={2,1,5,6,2,3};
        System.out.println("Max area: "+largestRectangleArea(heights));
    }
}
