import java.util.*;
import java.lang.*;

class MinimumMessiness
{
    public static int calculateMinimumMessiness(List<String> words, int lineWidth)
    {
        int[] dpTable=new int[words.size()];
        Arrays.fill(dpTable, Integer.MAX_VALUE);

        //Start with the first words
        int blanksLeft=lineWidth-words.get(0).length();
        dpTable[0]=blanksLeft*blanksLeft;

        //Iterate through all words
        for(int i=1;i<words.size(); i++)
        {
            //Calculate the messiness of the current word
            blanksLeft=lineWidth-words.get(i).length();
            dpTable[i]=blanksLeft*blanksLeft+dpTable[i-1];

            //Start from j=i-1 so that you don't have to check for all the combinations. The moment you run out of space for the previous line, don't try to add new words to that line now.
            for(int j=i-1;j>=0;j--)
            {
                blanksLeft-=(words.get(j).length()+1);
                if(blanksLeft<0)
                    break;
                int previousMessiness=(j-1)<0 ? 0:dpTable[j-1];
                int currentMessiness=blanksLeft*blanksLeft;
                dpTable[i]=Math.min(dpTable[i], previousMessiness+currentMessiness);
            }
        }
        return dpTable[words.size()-1];
    }

    public static void main(String args[])
    {
        List<String> words=new ArrayList<String>()
        {{
          add("Jack");
          add("and");
          add("Jill");
          add("went");
          add("up");
          add("the");
          add("hill");
        }};
        int minimumMessiness=calculateMinimumMessiness(words, 10);
        System.out.println("Minimum messiness: "+minimumMessiness);
    }
}
