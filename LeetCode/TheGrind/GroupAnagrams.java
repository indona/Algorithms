import java.lang.*;
import java.util.*;

public class GroupAnagrams
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result=new ArrayList<List<String>>();

        if(strs==null || strs.length==0)
            return result;

        Map<String, List<String>> map=new HashMap<String, List<String>>();
        for(String word: strs)
        {
            char[] arr=word.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());

            map.get(key).add(word);
        }

        for(String key: map.keySet())
            result.add(map.get(key));

        return result;
    }

    public static void main(String args[])
    {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result=new ArrayList<List<String>>();
        result=groupAnagrams(strs);

        for(List<String> list: result)
            System.out.println(Arrays.toString(list.toArray()));
    }
}
