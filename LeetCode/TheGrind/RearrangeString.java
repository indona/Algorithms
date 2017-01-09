import java.util.*;
import java.lang.*;

public class RearrangeString
{
    public static String rearrangeString(String str, int k)
    {
        //Idea is to implement this problem in a round robin manner using a greedy approach. Find the frequency of each character and start distributing the alphabets according to their frequencies in decreasing order.

        if(str==null || str.length()==0)
            return null;

        if(k==0)
            return str;

        //Calculate the frequency of each character
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++)
        {
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
        }

        //Create a priority queue of HashMap entries to sort the characters according to their frequency. In case of ties, break lexicographically.
        PriorityQueue<Character> pq=new PriorityQueue<Character>(new Comparator<Character>()
        {
            public int compare(Character c1, Character c2)
            {
                if(map.get(c1)!=map.get(c2)) //different frequencies
                    return map.get(c2).intValue()-map.get(c1).intValue(); //**.intValue() IMP!!!
                else //Ties, break lexicographically
                    return (c1.compareTo(c2));
            }
        });

        //Add the elements to the queue - Highest frequency element first.
        for(Character c: map.keySet())
            pq.offer(c);

        int len=str.length();
        StringBuilder sb=new StringBuilder();

        //For generating the modified string, we need to append characters in a round robin manner, where freq=min(k, strlen).
        //For each iteration of the round robin - poll the highest frequency element from the queue and append it to the final result string. Update the frequency in the map. If the character's frequency>0, we need to consider it for the next iteration. So, store it in a temp list, so that elements in this list can be added to the queue after this iteration finishes.
        //Repeat till one iteration is over.
        while(!pq.isEmpty())
        {
            int count=Math.min(k, len);
            List<Character> buffer=new ArrayList<Character>();

            for(int i=0;i<count;i++)
            {
                if(pq.isEmpty())
                    return "";

                char c=pq.poll();
                sb.append(c);
                map.put(c, (map.get(c)-1));
                len--;

                if(map.get(c)>0)
                    buffer.add(c);
            }

            for(char c: buffer)
            {
                if(map.get(c)>0)
                    pq.add(c);
            }
        }

        return sb.length()==str.length() ? sb.toString():null;
    }

    public static void main(String args[])
    {
        String str="aa";
        System.out.println("String: "+str+" Rearranged: "+rearrangeString(str, 2));

        String str2="aaadbbcc";
        System.out.println("String: "+str+" Rearranged: "+rearrangeString(str2, 3));
    }
}
