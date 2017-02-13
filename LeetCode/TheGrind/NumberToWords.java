public class NumberToWords
{
    /*
    The idea behind this problem is to grup the numbers in chunks of three and build incrementally for each of the group.
    Examples:
    123: One hundred twenty three
    45123: Forty five thousand one hundred twenty three
    456123: Four hundred fifty six thousand one hundred twenty three
    7456123: Seven million four hundred fifty six thousand one hundred twenty three
    789456123: Seven hundred eighty nine million four hundred fifty six thousand one hundred twenty three
    1789456123: One billion seven hundred eighty nine million four hundred fifty six thousand one hundred twenty three
    */

    static final String[] below20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static final String[] tens={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static final String[] thousands={"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int num)
    {
        if(num==0)
            return "Zero";

        int i=0;
        String word="";

        while(num>0)
        {
            if(num%1000!=0)
                word=helper(num%1000) + thousands[i] + " "+ word;

            num/=1000;
            i++;
        }
        return word.trim();
    }

    public static String helper(int n)
    {
        if(n==0)
            return "";
        else if(n<20)
            return below20[n]+" ";
        else if(n<100)
            return tens[n/10]+" "+helper(n%10);
        else
            return below20[n/100] + " Hundred "+ helper(n%100);
    }

    public static void main(String args[])
    {
        System.out.println("1789456123: "+numberToWords(1789456123));
        System.out.println("0: "+numberToWords(0));
        System.out.println("7456123: "+numberToWords(7456123));
    }
}
