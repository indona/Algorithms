import java.util.*;
import java.lang.*;

class LookAndSay
{
    public static String lookAndSay(int n)
    {
        //sanity check
        if (n<=0)
            return "";

        //Generate sequence
        String sequence="1";
        for(int i=0;i<n-1;i++)
            sequence=generateNext(sequence);

        return sequence;
    }

    public static String generateNext(String sequence)
    {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<sequence.length();i++)
        {
            int count=1;
            while(i<sequence.length()-1 && sequence.charAt(i)==sequence.charAt(i+1))
            {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(sequence.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String args[])
    {
        int n=8;
        System.out.println("N: "+n+", Sequence: "+lookAndSay(n));

        n=0;
        System.out.println("N: "+n+", Sequence: "+lookAndSay(n));

        n=1;
        System.out.println("N: "+n+", Sequence: "+lookAndSay(n));

        n=20;
        System.out.println("N: "+n+", Sequence: "+lookAndSay(n));
    }
}
