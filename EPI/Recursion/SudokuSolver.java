import java.lang.*;
import java.util.*;

class SudokuSolver
{
    public static boolean solve(char[][] board) //only for board size 9X9
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.') //ignore
                    continue;

                for(int k=1;k<=board.length;k++)
                {
                    board[i][j]=(char) k;
                    if(isValid(board, i, j) && solve(board))
                        return true;
                    board[i][j]='.';
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int i, int j)
    {
        HashSet<Character> set=new HashSet<Character>();

        //Check the cell's columns
        for(int k=0;k<9;k++)
        {
            if(set.contains(board[i][k]))
                return false;
            if(board[i][k]!='.')
                set.add(board[i][k]);
        }

        //Check the cell's rows
        set.clear();
        for(int k=0;k<9;k++)
        {
            if(set.contains(board[k][j]))
                return false;
            if(board[k][j]!='.')
                set.add(board[k][j]);
        }

        //Check the sub-cube
        set.clear();
        for(int k=0;k<3;k++)
        {
            for(int l=0;l<3;l++)
            {
                int x=i+k;
                int y=j+l;
                if(set.contains(board[x][y]))
                    return false;
                if(board[x][y]!='.')
                    set.add(board[x][y]);
            }
        }
        return true;
    }

    public static void main(String args[])
    {
      char[][] board=new char[9][9];
      String[] boardString ={".26...81.", "3..7.8..6", "4...5...7", ".5.1.7.9.", "..39.51..", ".4.3.2.5.", "1...3...2", "5..2.4..9", ".38...46."};
      for(int i=0;i<9;i++)
      {
          char[] charArr=boardString[i].toCharArray();
          for(int j=0;j<9;j++)
              board[i][j]=charArr[j];
      }

      boolean status=solve(board);
      System.out.println("Status: "+status);
    }
}
