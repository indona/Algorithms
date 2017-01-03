public class SearchMatrix2
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int col=matrix[0].length-1;
        int row=0;

        while(col>=0 && row<=matrix.length-1)
        {
            if(matrix[row][col]==target)
                return true;
            else
            {
                if(target>matrix[row][col])
                    row++;
                else
                    col--;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int[][] matrix={{1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        System.out.println("5 present: "+searchMatrix(matrix, 5));
        System.out.println("20 present: "+searchMatrix(matrix, 20));
    }
}
