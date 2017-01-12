import java.lang.*;
import java.util.*;

public class TextJustification
{
    public static List<String> fullJustify(String[] words, int maxWidth)
    {
        //The idea is to start working in a greedy manner and fit as many words as we can into a line within the given constraints.
        //For a line, count the number of words you can fit in the line. For every word other than the first word, count the number of chars as 1+word_length (to account for the space between words).
        //Once you have found the number of words to fit in a line, pass this to a justification function.
        //In the justification function, count the number of extra spaces that you need to fill in the line.
        //For each line, start with an array of blank spaces. Over-write the first word and then count the number of spaces you will add after this word.
        //To find the number of spaces (so that left gaps are given more spaces in case of uneven number of spaces for each gap).

        List<String> result=new ArrayList<String>();

        if(words==null || maxWidth==0)
        {
            result.add(new String());
            return result;
        }
        //Line: "This", "is", "an", "example", "of", "text", "justification." Width=16
        //i: 0 to 6
        String line;
        for(int i=0;i<words.length;i++)
        {
            int charCount=words[i].length(); //i=0
            int j=i+1; //j=1
            while(j<words.length && (charCount+words[j].length()+1)<=maxWidth) //j:1 to 3
            {
                charCount+=words[j].length()+1;
                j++;
            }

            if(j==words.length)
                line=justify(words, i, j-1, maxWidth, maxWidth);
            else
                line=justify(words, i, j-1, charCount, maxWidth); //0, 2, 10, 16

            result.add(line);
            j--;
            i=j;
        }
        return result;
    }

    public static String justify(String[] words, int start, int end, int charCount, int maxWidth) //0,2,10,16
    {
        char[] line=new char[maxWidth]; //16
        Arrays.fill(line, ' ');
        int pos=0;
        pos=fill(line, words[start], pos); //line, 0, 0 => return 4

        int trailingSpaces=maxWidth-charCount; //6
        int numGaps=end-start; //2
        while(start<end) //start<2
        {
            int spaces=(int) Math.ceil((trailingSpaces+0.0)/numGaps); //3
            pos=fill(line, words[++start], pos+1+spaces); // line, words[1], 4+1+3=7
            trailingSpaces-=spaces;
            numGaps--;
        }
        return (new String(line));
    }

    public static int fill(char[] line, String word, int pos)
    {
        for(char c: word.toCharArray())
            line[pos++]=c;

        return pos; //pos:4
    }

    public static void main(String args[])
    {
        String[] words={"This", "is", "an", "example", "of", "justified", "textual-data."};
        String[] words2={"a","b","c","d","e"};
        List<String> result=new ArrayList<String>();
        result=fullJustify(words, 16);
        System.out.println("Given: "+ Arrays.toString(words));
        for(String s: result)
            System.out.println("'"+s+"'");

        result.clear();
        result=fullJustify(words2, 3);
        System.out.println("\nGiven: "+ Arrays.toString(words));
        for(String s: result)
            System.out.println("'"+s+"'");
    }
}
