import java.util.*;

public class WordBreak2
{
    public static List<String> wordBreak(String s, List<String> wordDict)
    {
        //the idea behind this problem is to try and break the given string into words according to the given dictionary. We try all possible combinations, and when we find a word which is a valid start of s, we recursively try all possibilities to build the rest of the string.

        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }

    public static List<String> DFS(String s, List<String> wordDict, HashMap<String, List<String>> map)
    {
        //Check if the string's possible sentence structure has already been calculated and cached, return it directly.
        if(map.containsKey(s))
            return map.get(s);

        List<String> result=new ArrayList<String>();
        //If the string is null, after the rest of the string has been processed(base case), return an empty string
        if(s.length()==0)
        {
            result.add("");
            return result;
        }

        //Else try to find possible start words for the current string. We try all possible words from the given dictionary since we have to find all possible sentences.
        for(String word: wordDict)
        {
            //If my string s starts with the current word being considered from the dictionary, we keep it fixed and try to build the rest of the sentence by recursively calling DFS on the rest of the string.
            if(s.startsWith(word))
            {
                //If there is a valid breakdown, it will be returned in this list. Concatenate the words to get the build sentence with spaces.
                List<String> possibleSentence=new ArrayList<String>();
                possibleSentence=DFS(s.substring(word.length()), wordDict, map);
                for(String sentenceWord: possibleSentence)
                {
                    if(!sentenceWord.isEmpty())
                        result.add(word + " " + sentenceWord);
                    else
                        result.add(word);
                }
            }
        }
        //We keep adding the sentence breakdown of the string/substring to the global hashmap so as to avoid recomputations.
        map.put(s, result);
        return result;
    }

    public static void main(String args[])
    {
        String s="catsanddogs";
        List<String> wordDict=new ArrayList<String>(){{
          add("cat");
          add("cats");
          add("and");
          add("sand");
          add("dog");
          add("dogs");
        }};
        List<String> result=new ArrayList<String>();
        result=wordBreak(s, wordDict);
        System.out.println("Possible sentences: "+Arrays.toString(result.toArray()));
    }
}
