import java.lang.*;
import java.util.*;

class ReverseSentence
{
    public static String reverseSentence(char[] input)
    {
        //Sanity check
        if(input==null || input.length==0)
            return null;

        //disregard intial blanks if any
        int wordStartIndex=0;
        while(wordStartIndex<input.length && input[wordStartIndex]==' ')
            wordStartIndex++;

        //reverse each word
        for(int i=wordStartIndex;i<input.length;i++)
        {
            if(input[i]==' ')
            {
                reverse(input, wordStartIndex, i-1);
                wordStartIndex=i+1;
            }
        }
        reverse(input, wordStartIndex, input.length-1);

        //reverse complete sentence and return
        reverse(input, 0, input.length-1);
        return (new String(input));
    }

    public static void reverse (char[] input, int start, int end)
    {
        int mid=(start+end)/2;
        if(mid==0)
            return;
        while(start<=mid)
        {
            char temp=input[start];
            input[start]=input[end];
            input[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String args[])
    {
        String input ="Alice in Wonderland";
        String result=reverseSentence(input.toCharArray());
        System.out.println("Original String: "+input+", Reversed String: "+result);

        String input2 ="AliceinWonderland";
        String result2=reverseSentence(input2.toCharArray());
        System.out.println("Original String: "+input2+", Reversed String: "+result2);

        String input3 ="  ";
        String result3=reverseSentence(input3.toCharArray());
        System.out.println("Original String: "+input3+", Reversed String: "+result3);

        String input4 ="";
        String result4=reverseSentence(input4.toCharArray());
        System.out.println("Original String: "+input4+", Reversed String: "+result4);

        String input5 =" AliceinWonderland by Lewis Carroll";
        String result5=reverseSentence(input5.toCharArray());
        System.out.println("Original String: "+input5+", Reversed String: "+result5);
    }
}
