import java.util.*;
import java.lang.*;

public class HappyNumber
{
    public static boolean isHappy(int n)
    {
        HashSet<Integer> seen = new HashSet<Integer>();

        while(seen.add(n))
        {
            int sum=0;
            while(n>0)
            {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            if(sum==1)
                return true;

            n=sum;
        }
        return false;
    }

    public static void main(String args[])
    {
        Random numGen = new Random();
        int num = numGen.nextInt(1000);
        boolean result = isHappy(num);
        System.out.println("Number: "+ num+" Result: "+result);
    }
}
