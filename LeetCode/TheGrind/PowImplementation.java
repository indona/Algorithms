import java.util.*;

public class PowImplementation
{
    public static double myPow(double x, int n)
    {
        //The idea is to operate on the n in a bit wise fashion. The number of multiplications required is denoted by the number of 1s in N.

        double result=1.0;
        long absN=Math.abs((long)n);

        while(absN>0)
        {
            if((absN&1)==1) //i.e. LSB is set
                result*=x;
            absN>>=1;
            x*=x;
        }

        if(n<0)
            return 1/result;
        else
            return result;
    }

    public static void main(String args[])
    {
        System.out.println("x: 2.478, n=9, Result= "+myPow(2.478, 9));
        System.out.println("x: 2.478, n=-9, Result= "+myPow(2.478, -9));
        System.out.println("x: 2.478, n=9, Result= "+myPow(2.478, Integer.MIN_VALUE));
    }
}
