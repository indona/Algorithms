import java.util.*;
import java.lang.*;

class BinaryWatch
{
    public static List<String> readBinaryWatch(int num)
    {
        List<String> result=new ArrayList<String>();

        //Sanity
        if(num<0)
            return null;
        if(num==0)
        {
            result.add("0:00");
            return result;
        }
        //Since the range of hour and min is finite, go over each combination of hour and minute and see if the number of bits set in hour and minute add up to the given number of set bits in the input.
        for(int hour=0;hour<12;hour++)
        {
            for(int min=0;min<60;min++)
            {
                int setBits=countSetBits(hour)+countSetBits(min);
                //System.out.println("Hour: "+countSetBits(hour)+" Minute: "+countSetBits(min)+" Set bits: "+setBits);
                if(setBits==num)
                {
                    StringBuilder sb=new StringBuilder();
                    sb.append(hour);
                    sb.append(":");
                    if(min<10)
                        sb.append("0");
                    sb.append(min);

                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    public static int countSetBits(int num)
    {
        //Check the number of biuts set in the given number by anding with 1 and repeating it by right-shifting the given number
        int bits=0;
        while(num>0)
        {
            if((num&1)==1)
                bits++;
            num>>=1;
        }
        return bits;
    }

    public static void main(String args[])
    {
        List<String> result=new ArrayList<String>();
        int num=1;
        result=readBinaryWatch(num);
        System.out.println("For n="+num+" List of possible times: "+Arrays.toString(result.toArray())+"\n");

        num=3;
        result=readBinaryWatch(num);
        System.out.println("For n="+num+" List of possible times: "+Arrays.toString(result.toArray())+"\n");

    }
}
