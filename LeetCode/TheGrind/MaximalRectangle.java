import java.util.*;

public class MaximalRectangle
{
    public static int maximalRectangle(char[][] matrix)
    {
        //The idea behind this problem is to implement it using max rectancle in a histogram logic on each row of the given matrix.

        //Sanity
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        //Create the height matrix and initialize it based on the first row of the matrix
        int[] height=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
            if(matrix[0][i]=='1')
                height[i]=1;

        //Calculate the max area in this row based on the largest area in a histogram logic
        int maxArea=maxAreaInRow(height);

        //We perform the same operation row by row
        //For the next row, we re-calculate the height array using the current height array and the next row through recalculateHeight
        //We caculate the maximum area for that row using maxAreaInRow
        for(int i=1;i<matrix.length;i++)
        {
            recalculateHeight(matrix, height, i);
            maxArea=Math.max(maxArea, maxAreaInRow(height));
        }
        return maxArea;
    }

    public static void recalculateHeight(char[][] matrix, int[] height, int rowNum)
    {
        //Calculate the height array based on the current row of the matrix. If it is a 0, reset it to 0. Else increment height by 1.
        for(int i=0;i<height.length;i++)
        {
            if(matrix[rowNum][i]=='1')
                height[i]+=1;
            else
                height[i]=0;
        }
    }

    public static int maxAreaInRow(int[] heights)
    {
        //For each row, we calculate the height array and using the height array calculate the max area possible.
        //maxAreaInRow calculation is based on max area in a histogram.
        int maxArea=0, i=0;
        Stack<Integer> stack=new Stack<Integer>();

        while(i<heights.length)
        {
              //If my stack is empty or if I see taller buildings coming in, push them into the stack
              if(stack.isEmpty() || heights[i]>=heights[stack.peek()])
              {
                  stack.push(i);
                  i++;
              }
              else
              //If a smaller building comes in, pop out till you can insert this new building and keep calculating the maxArea.
              {
                  int index=stack.pop();
                  int height=heights[index];
                  int width=stack.isEmpty() ? i : i-stack.peek()-1;
                  maxArea=Math.max(maxArea, (height*width));
              }
        }

        // In case we are out of new buildings and we still have buildings in the stack, Pop out any remaining buildings.
        while(!stack.isEmpty())
        {
            int index=stack.pop();
            int height=heights[index];
            int width=stack.isEmpty() ? i:i-stack.peek()-1;
            maxArea=Math.max(maxArea, width*height);
        }
        return maxArea;
    }

    public static void main(String args[])
    {
        char[][] matrix={
          {'1', '1', '1', '0', '0'},
          {'1', '0', '1', '1', '1'},
          {'1', '1', '1', '1', '1'},
          {'1', '0', '0', '1', '0'}};

          System.out.println("Max rectancle area: "+maximalRectangle(matrix));
    }
}
