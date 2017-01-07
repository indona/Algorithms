import java.lang.*;

class OneEditDistance
{
    public static boolean isOneEditDistance(String s, String t)
    {
        //if the difference in string lengths is >1, the result will always be false.
        if(Math.abs(s.length()-t.length())>2)
            return false;

        //Go through each elements of the smaller string at a time
        for(int i=0;i<Math.min(s.length(), t.length());i++)
        {
            if(s.charAt(i)!=t.charAt(i))
            {
                //There are three cases:
                //If the lengths are equal: Then replacing this character is the only option. The rest of the strings must be equal
                if(s.length()==t.length())
                    return s.substring(i+1).equals(t.substring(i+1));

                //If s is smaller than t, deleting the current character from t is the only option. The rest of the strings must be equal.
                else if(s.length()<t.length())
                    return s.substring(i).equals(t.substring(i+1));

                //Else if t is smaller than s, deleting from s is the only option. The rest of the strings must match.
                else
                  return s.substring(i+1).equals(t.substring(i));
            }
        }

        //If all characters of the smaller string matches with the bigger string, the only case left to check is if the difference in length is 1.
        return Math.abs(s.length()-t.length())==1;
    }

    public static void main(String args[])
    {
        System.out.println("Status: "+isOneEditDistance("Hello", "Heloo"));
        System.out.println("Status: "+isOneEditDistance("Hello", "Heloi"));
    }
}
