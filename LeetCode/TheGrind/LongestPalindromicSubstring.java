public class LongestPalindromicSubstring
{
    public static String longestPalindromeDP(String s)
    {
        //Sanity
        if(s==null || s.length()<2)
            return s;

        //The idea behind this problem is to use DP to store the subproblem result in the naive soltuion.
        //We consider substring of all length, len : 0 to s.length-1. For each such substring we consider all possible start points, say i.
        //We calculate the end points using the start and the substring length under consideration. j=i+len
        //Now for this substring to be a palindrome, the last and first characters must match and the rest of the string must be a palindrome too.
        //To store this sub-problem information, we create a 2D boolean array. We also keep a running maxlen of a palindromic substring we've seen so far and the substring too.

        int len=s.length();
        int maxLen=0;
        boolean[][] dp=new boolean[len][len];
        String maxSubstr=null;

        for(int l=0;l<len;l++)//loop for all substring sizes
        {
            for(int i=0;i<len-l;i++)//All valid start points (0 - len-l)
            {
                int j=i+l;  //Calculating the end point
                System.out.println("Checking i,j: "+i+", "+j+" with length: "+l);

                //Check if the first and last characters match and if they do check if the rest of the string (exclusing the first and last characters) is a palindrome. Or if the substring we are considering is of length 2 i.e. there is no intermediate substring to check.
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==true))
                {
                    dp[i][j]=true;

                    if(j-i+1>maxLen) //If the current substring is longer than the running max
                    {
                        maxLen=j-i+1;
                        maxSubstr=s.substring(i, j+1);
                        System.out.println("Maxsubstr: "+maxSubstr);
                    }
                }
            }
        }
        return maxSubstr;
    }

    public static String longestPalindrome(String s)
    {
        //Sanity
        if(s.length()<2)
            return s;

        //The idea behind this solution is to remove the O(n2) space from the DP solution. We consider each character and pair of two consecutive characters as centers and try to build the maximum length palindromic substring. We store the running max in two variables.

        int len=s.length();
        String maxSubstr=s.substring(0,1);

        for(int i=0;i<len;i++)
        {
            String candidate1=generateString(s, i, i);
            if(candidate1.length()>maxSubstr.length())
                maxSubstr=candidate1;

            String candidate2=generateString(s, i, i+1);
            if(candidate2.length()>maxSubstr.length())
                maxSubstr=candidate2;
        }
        return maxSubstr;
    }

    public static String generateString(String s, int start, int end)
    {
        //Function to generate the longest length palindrome for the centers.
        while(start>=0 && end<=s.length()-1 && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }

    public static void main(String args[])
    {
        String s="abdda";
        System.out.println("Longest Palindromic Substring for: "+s+" is: "+longestPalindrome(s));
    }
}
