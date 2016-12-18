import java.util.*;
import java.lang.*;

class PhoneMnemonicGenerator
{
    public static final String[] mapping = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static List<String> generateAllMnemonics(String phoneNumber)
    {
        List<String> resultList=new ArrayList<String>();

        if(phoneNumber==null || phoneNumber.length()==0)
            return resultList;

        char[] mnemonic = new char[phoneNumber.length()];
        generateMnemonic(phoneNumber, 0, mnemonic, resultList);
        return resultList;
    }

    public static void generateMnemonic(String phoneNumber, int digit, char[] mnemonic, List<String> resultList)
    {
        if(digit==phoneNumber.length())
        {
            resultList.add(new String(mnemonic));
            return;
        }
        //258 -> [ABC] [JKL] [TUV]
        //phoneNumber.charAt(digit) : the phone number digit under consideration
        //mapping[phoneNumber.charAt(digit) - '0'] : number of alphabets assigned to that digit in the mapping
        //Eg. Digit-2 Length-2 (ABC), Digit-9 Length-4(WXYZ)
        for(int i=0; i<(mapping[phoneNumber.charAt(digit) - '0'].length());i++)
        {
            mnemonic[digit]=mapping[phoneNumber.charAt(digit) - '0'].charAt(i);;
            generateMnemonic(phoneNumber, digit+1, mnemonic, resultList);
        }
    }

    public static void main(String args[])
    {
        String phoneNumber="206";
        List<String> mnemonics=generateAllMnemonics(phoneNumber);
        System.out.println("Phone Number: "+phoneNumber+"\nMnemonics: "+Arrays.toString(mnemonics.toArray()));

        String phoneNumber1="";
        List<String> mnemonics1=generateAllMnemonics(phoneNumber1);
        System.out.println("Phone Number: "+phoneNumber1+"\nMnemonics: "+Arrays.toString(mnemonics1.toArray()));
    }
}
