public class PaintHouseII
{
    public static int minCostII(int[][] costs)
    {
        if(costs.length==0)
            return 0;

        //The logic behind this problem is:
        //If we have no adjacent color constraint, then we would have picked the min cost color for each house.
        //With the adjacent color constraint, if my current house's min cost color matches the previous house's min cost color =>
        //We don't choose this color, we choose the 2nd min color.
        //For each house, we keep track of the min1 and min2 cost, as well as for its previous house.
        //Before assigning the minimum cost color to this house, we compare with the previous house if it is same.
        //If yes, we choose min2 else stick to min1

        //Mins and minIndex for previous house
        int min1=0, min2=0, minIndex=-1;

        //iterate for all houses
        for(int i=0;i<costs.length;i++)
        {
            //Mins and minIndex for this current house - we go through all colors to find the min possible for this house
            int m1=Integer.MAX_VALUE, m2=Integer.MAX_VALUE, mIdx=-1;

            for(int j=0;j<costs[0].length;j++)
            {
                //If this color is not the same as previous house's min, we consider Min1 for the previous house, else Min2
                int cost=costs[i][j]+ (j==minIndex ? min2 : min1);

                //If this cost is less than the current min : cost<m1<m2
                if(cost<m1)
                {
                    m2=m1;
                    m1=cost;
                    mIdx=j;
                }
                else if(cost<m2) //Cost not less than min1, but less than min2 : m1<cost<m2
                {
                    m2=cost;
                }
            }
            //Update these for the next house
            min1=m1; min2=m2; minIndex=mIdx;
        }
        return min1;
    }

    public static void main(String args[])
    {
        int[][] costs={{1,2,1},{2,3,7},{3,4,1},{1,0,0}};
        System.out.println("Min cost for painting all houses: "+minCostII(costs));
    }
}
