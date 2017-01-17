import java.lang.*;
import java.util.*;

public class WordLadder
{
    static class WordNode
    {
        String word;
        int steps;

        WordNode(String word, int steps)
        {
            this.word=word;
            this.steps=steps;
        }
    }

    //The idea behind this problem is BFS. We start at the beginWord and change a single character in the word to see if the modified word is a part of the given dictionary. If yes, we explore the next word by modifying another character.
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        //We add the endWord to the word list so that we can directly check if the modified word is the endWord.
        wordList.add(endWord);

        //For BFS we create a queue of WordNodes.
        LinkedList<WordNode> queue=new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));

        while(!queue.isEmpty())
        {
            //remove the first word and alter the characters one at a time to see if we can reach the end word.
            WordNode top=queue.poll();
            String currentWord=top.word;

            if(currentWord.equals(endWord))
                return top.steps;

            char[] arr=currentWord.toCharArray();
            for(int i=0;i<arr.length;i++)
            {
                for(char c='a';c<'z';c++)
                {
                    char temp=arr[i];
                    arr[i]=c;

                    String nextWord=new String(arr);
                    if(wordList.contains(nextWord))
                    {
                        queue.add(new WordNode(nextWord, top.steps+1));
                        wordList.remove(nextWord);
                    }
                    arr[i]=temp;
                }
            }
        }
        return 0;
    }

    public static void main(String args[])
    {
        Set<String> wordList=new HashSet<String>(){{
          add("hot");
          add("dot");
          add("dog");
          add("lot");
          add("log");
        }};
        String beginWord="hit";
        String endWord="cog";
        System.out.println("Number of steps: "+ladderLength(beginWord, endWord, wordList));
    }
}
