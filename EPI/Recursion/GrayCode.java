import java.util.*;
import java.lang.*;

class GrayCode
{
    public static List<Integer> generateGrayCode(int n)
    {
        if(n==0)
        {
            List<Integer> codeList=new ArrayList<Integer>();
            codeList.add(0);
            return codeList;
        }

        List<Integer> codeList=generateGrayCode(n-1);
        int newCode=1<<(n-1);

        for(int i=codeList.size()-1;i>=0;i--)
        {
            int code=newCode+codeList.get(i);
            codeList.add(code);
        }
        return codeList;
    }

    public static void main(String args[])
    {
        List<Integer> codeList=new ArrayList<Integer>();
        codeList=generateGrayCode(3);
        System.out.println("Gray code for n=3 is: "+Arrays.toString(codeList.toArray()));

        codeList.clear();
        codeList=generateGrayCode(5);
        System.out.println("Gray code for n=5 is: "+Arrays.toString(codeList.toArray()));

        codeList.clear();
        codeList=generateGrayCode(0);
        System.out.println("Gray code for n=0 is: "+Arrays.toString(codeList.toArray()));
    }
}
