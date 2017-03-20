import java.lang.*;

public class ReverseString
{
    public static String reverseStr(String s, int k)
    {
        if(s==null || s.length()==0)
            return new String("");

        int len=s.length();
        int step=2*k;


        int start=0;
        while(start+step<=len)
        {
            int end=start+step;
            int mid=start+k;

            s=s.substring(0, start)+reverse(s, start, mid)+s.substring(mid);

            start=end;
        }

        if(len-start<k)
            s=s.substring(0, start)+reverse(s, start, len);
        else if(len-start>=k && len-start<2*k)
            s=s.substring(0, start)+reverse(s, start, start+k)+s.substring(start+k);

        return s;
    }

    public static String reverse(String s, int start, int end)
    {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }

    public static void main(String args[])
    {
        String s="abcd";
        System.out.println("Before: "+s+", After: "+reverseStr(s, 2));
    }
}
