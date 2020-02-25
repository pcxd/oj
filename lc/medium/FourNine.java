package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FourNine
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return null;

        Map<String, List<String>> buff = new HashMap<>();
        for(String str : strs)
        {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String tStr = new String(cArr);

            if(!buff.containsKey(tStr))
                buff.put(tStr, new ArrayList<>());
            buff.get(tStr).add(str);
        }

        return new ArrayList<>(buff.values());
    }


    public static void main(String[] args)
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(strs);
        System.out.println(ret);
    }
}
