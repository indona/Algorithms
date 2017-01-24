import java.lang.*;

public class ReverseWords
{
    public static String reverseWords(String s)
    {
        if(s==null || s.length()==0)
            return new String("");

        String[] arr=s.split(" ");

        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(!arr[i].equals(""))
                sb.append(arr[i]).append(" ");
        }

        if(sb.length()==0)
            return new String("");
        else
            return sb.substring(0, sb.length()-1);
    }

    public static void main(String args[])
    {
        String s="the sky is blue";
        System.out.println("Reversed: "+reverseWords(s));
    }
}
