import java.lang.*;
import java.util.*;

class PhoneMnemonic
{
    final static String[] map={"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits)
    {
        List<String> result=new ArrayList<String>();

        //Sanity
        if(digits==null)
            return null;
        if(digits.length()==0)
            return result;

        char[] partialMnemonic=new char[digits.length()];
        _letterCombinations(0, digits, partialMnemonic, result);

        return result;
    }

    public static void _letterCombinations(int index, String digits, char[] partialMnemonic, List<String>result)
    {
        if(index==digits.length())
        {
            String mnemonic=new String(partialMnemonic);
            result.add(mnemonic);
            return;
        }

        //For each digit, find its mapping from the digit-character map and recursively find all possible combinations.
        String mapping=map[digits.charAt(index)-'0'];
        for(int j=0;j<mapping.length();j++)
        {
            partialMnemonic[index]=mapping.charAt(j);
            _letterCombinations(index+1, digits, partialMnemonic, result);
        }
    }

    public static void main(String args[])
    {
        List<String> result=new ArrayList<String>();

        String digits="23";
        result=letterCombinations(digits);
        System.out.println("Digits: "+digits+"\nMnemonics: "+ Arrays.toString(result.toArray()));

        digits="425";
        result=letterCombinations(digits);
        System.out.println("Digits: "+digits+"\nMnemonics: "+ Arrays.toString(result.toArray()));

        digits="";
        result=letterCombinations(digits);
        System.out.println("Digits: "+digits+"\nMnemonics: "+ Arrays.toString(result.toArray()));
    }
}
