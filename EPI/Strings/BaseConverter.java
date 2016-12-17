import java.lang.*;
import java.util.*;

class BaseConverter
{
    public static String baseConverter(String number, int base1, int base2)
    {
        boolean isNegative = false;
        if(number.charAt(0)=='-')
            isNegative=true;

        int convertedNumber=0;
        for(int i= (isNegative==false? 0:1);i<number.length();i++)
            convertedNumber=convertedNumber*base1+(number.charAt(i)-'0');

        StringBuilder result=new StringBuilder();
        while(convertedNumber!=0)
        {
            int digit=convertedNumber%base2;
            if(digit>9)
                result.append((char)('A'+digit-10));
            else
                result.append(digit);

            convertedNumber/=base2;
        }

        if(isNegative)
            result.append('-');

        result.reverse();
        return result.toString();
    }

    public static void main(String args[])
    {
        String text="-615";
        int base1=7;
        int base2=13;
        String result = baseConverter(text, base1, base2);
        System.out.println("String: "+text+", Base1: "+base1+", Base2: "+base2+", Converted String: "+result);
    }
}
