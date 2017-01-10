import java.util.*;

public class ValidSudoku
{
    public static boolean isValidSudoku(char[][] board)
    {
        //The idea behind this problem is to check if all column, row and cube constraints are fulfilled.
        //By constraints we mean absence of repeating characters in a row/column/cell
        if(board==null || board.length==0 || board[0].length==0)
            return false;

        //Check column constraints
        for(int i=0;i<9;i++)
        {
            boolean[] cols=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(cols[(int) (board[i][j]-'1')])
                        return false;
                    cols[(int) (board[i][j]-'1')]=true;
                }
            }
        }

        //check row constraints
        for(int i=0;i<9;i++)
        {
            boolean[] rows=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                    if(rows[(int) (board[j][i]-'1')])
                        return false;
                    rows[(int) (board[j][i]-'1')]=true;
                }
            }
        }

        //check cube constraints
        for(int i=0;i<9;i++)
        {
            boolean[] cube=new boolean[9];
            for(int row=3*(i/3);row<3*(i/3)+3;row++)
            {
                for(int col=3*(i%3);col<3*(i%3)+3;col++)
                {
                    if(board[row][col]!='.')
                    {
                        if(cube[(int) (board[row][col]-'1')])
                            return false;
                        cube[(int) (board[row][col]-'1')]=true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String args[])
    {
        String[] board1={".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char[][] board=new char[9][9];
        int i=0;
        for(String s: board1)
        {
            board[i]=s.toCharArray();
            i++;
        }
        System.out.println("Result: "+isValidSudoku(board));

    }
}
