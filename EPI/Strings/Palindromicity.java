import java.lang.*;
import java.util.*;

class Palindromicity
{
    public static boolean isPalindromic(String s)
    {
        if(s==null || s.length()==0)
            return false;

        boolean charPresent=false;
        int i=0, j=s.length()-1;
        while(i<j)
        {
            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j)
                i++;

            while(!Character.isLetterOrDigit(s.charAt(j)) && i<j)
                j--;

            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
            {
                charPresent=true;
                return false;
            }
            i++;
            j--;
        }
        if(charPresent==true)
            return true;
        else
            return false;
    }

    public static void main(String args[])
    {
        String s1 = new String();
        System.out.println("Palindromicity check for "+s1+" : " +isPalindromic(s1));

        String s2="  ";
        System.out.println("Palindromicity check for :"+s2+" : " +isPalindromic(s2));

        String s3="A man, a plan,; a canal, Panama...";
        System.out.println("Palindromicity check for : "+s3+" : " +isPalindromic(s3));

    }
}
