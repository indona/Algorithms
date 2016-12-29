import java.util.*;
import java.lang.*;

public class WordSearch
{
    public static boolean exist(char[][] board, String word)
    {
        //Idea: Scan through the board to find the starting letter of the word.
        //Once found, spawn off DFS to see if the complete word can be found.
        //If fails, repeat for the next cell which matches the starting letter of the word

        //Sanity
        if(board==null || word==null || board.length==0 || word.length()==0)
            return false;

        //Search for word start character in the board
        boolean status=false;
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[0].length;col++)
            {
                status=dfs(board, row, col, word, 0);
                if (status)
                    return true;
            }
        }
        return status;
    }

    public static boolean dfs(char[][] board, int row, int col, String word, int index)
    {
        int len=board.length;
        int width=board[0].length;

        if(row<0 || row>=len || col<0 || col>=width) //Out of bounds
            return false;

        if(word.charAt(index)!=board[row][col]) //Char doesn't match, prune the search immediately
            return false;
        else
        {
            char temp=board[row][col]; //Char matches, but full word search is not complete
            board[row][col]='#';

            if(index==word.length()-1) //If full word found, return true
                return true;
            //Spawn out 4 DFS and see if any one of them returns true. If yes, the word has been found.
            else if (dfs(board, row-1, col, word, index+1) || dfs(board, row+1, col, word, index+1) || dfs(board, row, col-1, word, index+1) || dfs(board, row, col+1, word, index+1))
                  return true;

            board[row][col]=temp;
            return false;
        }
    }

    public static void main(String args[])
    {
        char[][] board={{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println("Search String: ABCCED, Status: "+exist(board, "ABCCED"));

        char[][] board2={{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println("Search String: SEE, Status: "+exist(board2, "SEE"));

        char[][] board3={{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println("Search String: \"\", Status: "+exist(board3, ""));

    }
}
