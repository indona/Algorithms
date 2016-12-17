import java.util.*;
import java.lang.*;

class StringIntAPI
{
    public static int stringToInt(String number)
    {
        int result=0;
        for(int i= number.charAt(0)=='-'? 1:0 ; i<number.length(); i++)
        {
            int digit=number.charAt(i)-'0';
            result=result*10+digit;
        }
        if(number.charAt(0)=='-')
            return -result;
        else
            return result;
    }

    public static String intToString(int number)
    {
        StringBuilder result = new StringBuilder();
        boolean isNegative=false;
        if(number<0)
        {
            number = -number;
            isNegative=true;
        }
        while(number!=0)
        {
            result.append((char) number%10);
            number/=10;
        }

        if(isNegative)
            result.append('-');

        result.reverse();
        return result.toString();
    }

    public static void main(String args[])
    {
        String text = "-1234";
        System.out.println("String to int: \n"+"String: "+text+" Int: "+stringToInt(text));

        int number=-785634;
        System.out.println("Int to string: \n"+"Int: "+number+" String: "+intToString(number));

    }
}
