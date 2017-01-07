import java.util.*;
import java.lang.*;

public class EditDistance
{
    public static int editDistance(String s, String t)
    {
        int l1=s.length();
        int l2=t.length();

        int[][] dpTable=new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++)
            dpTable[i][0]=i;

        for(int i=0;i<=l2;i++)
            dpTable[0][i]=i;

        for(int i=0;i<l1;i++)
        {
            for(int j=0;j<l2;j++)
            {
                if(s.charAt(i)==t.charAt(j))
                    dpTable[i+1][j+1]=dpTable[i][j];
                else
                {
                    int replace=dpTable[i][j]+1;
                    int insert=dpTable[i][j+1]+1;
                    int delete=dpTable[i+1][j]+1;

                    dpTable[i+1][j+1]=Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dpTable[l1][l2];
    }

    public static void main(String args[])
    {
        System.out.println("Edit distance: "+editDistance("tuesday", "thursday"));
    }
}
