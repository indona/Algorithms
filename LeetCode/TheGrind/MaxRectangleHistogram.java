import java.lang.*;
import java.util.*;

public class MaxRectangleHistogram
{
    public static int largestRectangleArea(int[] heights)
    {
        if (heights==null || heights.length==0)
            return 0;

        //Create a stack of elements
        Stack<Integer> stack=new Stack<Integer>();

        int i=0, maxArea=0;
        while(i<heights.length)
        {
            //If the stack is empty or the heights are in increasing order keep pushing
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()])
            {
                stack.push(i);
                i++;
            }
            //If a bar with lower height comes in, pop out elements until you can insert this new one.
            //While popping out, calculate the area of each popped bar - width will be caculated by starting from the current i till the last smaller bar as present in the stack (tos).
            else
            {
                int index=stack.pop();
                int height=heights[index];
                int width=stack.isEmpty() ? i:i-stack.peek()-1;
                int area=height*width;
                maxArea=Math.max(maxArea, area);
            }
        }
        //Pop out elements one at a time and check if anything exceeds the current max.
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
