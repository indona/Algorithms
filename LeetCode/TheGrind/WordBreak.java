import java.util.*;

public class WordBreak
{
    public static boolean wordBreak(String s, List<String> wordDict)
    {
        //The idea behind this problem is to try and find, for every index (i) of S, if there exists any cut between 0 and i which breaks it into valid words in the dictionary.
        //Eg. leetcode (dict - le, etc, ode)
        //For i=2 => dp[0]=true and s.substring(0,2)=le and le is present in the ditionary.
        //This makes dp[2]=true
        if(wordDict==null || s.length()==0 || s==null)
            return false;

        boolean[] dpTable=new boolean[s.length()+1];
        dpTable[0]=true;

        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                //Find any cut, which breaks this part of the string into words which are valid dictionary entries
                if(dpTable[j])
                {
                    String word=s.substring(j, i);
                    if(wordDict.contains(word)) //If found, break and set the dpTable entry to true
                    {
                        dpTable[i]=true;
                        break;
                    }
                }
            }
        }
        return dpTable[s.length()];
    }

    public static void main(String args[])
    {
        List<String> wordDict=new ArrayList<String>(){{
          add("ode");
          add("etc");
          add("le");
          add("leet");
        }};
        System.out.println("Can break? "+wordBreak("leetcode", wordDict));
    }
}
