import java.lang.*;
import java.util.*;

class TrappingRainWater2
{
    public static class Cell
    {
        int row, col, height;
        Cell(int row, int col, int height)
        {
            this.row=row;
            this.col=col;
            this.height=height;
        }
    }

    public static int trapRainWater(int[][] heights)
    {
        //Sanity
        if(heights==null || heights.length==0 || heights[0].length==0)
            return 0;

        PriorityQueue<Cell> pq=new PriorityQueue<Cell>(1, new Comparator<Cell>()
        {
            public int compare(Cell a, Cell b)
            {
                return a.height-b.height;
            }
        });

        //Visit all boundary cells and add them to the priority queue and mark them as visited.
        int m=heights.length-1;
        int n=heights[0].length-1;
        boolean[][] visited=new boolean[heights.length][heights[0].length];
        //Left and Right
        for(int i=0;i<=m;i++)
        {
            visited[i][0]=true;
            visited[i][n]=true;
            pq.add(new Cell(i, 0, heights[i][0]));
            pq.add(new Cell(i, n, heights[i][n]));
        }

        //Top and Bottom
        for(int i=0;i<=n;i++)
        {
            visited[0][i]=true;
            visited[m][i]=true;
            pq.add(new Cell(0, i, heights[0][i]));
            pq.add(new Cell(m, i, heights[m][i]));
        }

        //Pick the boundary with smallest height and check its neighbors. If it has a shorter neighbor, collect water in it.
        //Now update the cell's height to its volume. Add all its neighbors to the queue.
        //Repeat.
        int water=0;
        int[][] directions={{-1, 0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            //Extract the min height cell from the queue
            Cell current=pq.poll();

            //Check all its neighbors
            for(int[] direction: directions)
            {
                int row=current.row+direction[0];
                int col=current.col+direction[1];

                //If it is a valid non-boundary cell and has not been processed, see if its height is lesser than the current cell. If yes, add the (height difference)trapped water to the waterCount and update the cell's height to the "current" cell's height so that it is not counted twice.
                if(row>0 && row<m && col>0 && col<n && visited[row][col]!=true)
                {
                    visited[row][col]=true;
                    //current.height-height[row][col]) is the difference in height -> If positive, then it is the amount of trapped water.
                    water+=Math.max(0, current.height-heights[row][col]);
                    pq.add(new Cell(row, col, Math.max(current.height, heights[row][col])));
                }
            }
        }
        return water;
    }

    public static void main(String args[])
    {
        int[][] heights= {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        System.out.println("Trapped water: "+trapRainWater(heights));
    }
}
