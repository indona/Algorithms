import java.util.*;
import java.lang.*;

class RomanToInteger
{
    public static final HashMap<Character, Integer> map=new HashMap<Character, Integer>()
    {
      {
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
      }
    };

    //Logic: Eg. LIX
    //Start from the right. If the previous digit is smaller than the current one, then it is an exception. To find its combined value, subtract the preceeding digit's value from the current. IX: 10-1=9
    //In the next iteration, if the preceeding value>current, then add the values: L(IX)=50+9=59
    public static int romanToInt(String s)
    {
        if(s==null || s.length()==0)
            return 0;

        int result=map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--)
        {
            if(s.charAt(i)<s.charAt(i+1))
                result-=map.get(s.charAt(i));
            else
                result+=map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String args[])
    {
        String i="XXXXIIII";
        System.out.println("Roman: "+i+", Value: "+romanToInt(i));

        String i2="LIX";
        System.out.println("Roman: "+i2+", Value: "+romanToInt(i2));
    }
}
