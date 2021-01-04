package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ThreeNineFive
{
    public static int longestSubstring(String s, int k)
    {
        if(s == null || s.isEmpty() || k > s.length())
            return 0;
        if(k == 1)
            return s.length();

        char[] arr = s.toCharArray();
        Map<Character, Integer> cc = new HashMap<>();
        for(char c : arr)
            cc.put(c, cc.getOrDefault(c, 0) + 1);

        Set<Character> invalid = new HashSet<>();
        for(Map.Entry<Character, Integer> e : cc.entrySet())
            if(e.getValue() < k)
                invalid.add(e.getKey());

        int ret = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int iRet = findLongest(arr, invalid, i, k);
            ret = Math.max(ret, iRet);
        }

        return ret;
    }

    private static int findLongest(char[] arr, Set<Character> invalid, int start, int k)
    {
        int ret = 0;
        Set<Character> buff = new HashSet<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for(int i = start; i < arr.length; i++)
        {
            if(invalid.contains(arr[i]))
                break;
            if(!cnt.containsKey(arr[i]))
            {
                cnt.put(arr[i], 0);
                buff.add(arr[i]);
            }

            cnt.put(arr[i], cnt.get(arr[i]) + 1);
            if(buff.contains(arr[i]) && cnt.get(arr[i]) >= k)
                buff.remove(arr[i]);

            if(buff.isEmpty())
                ret = i - start + 1;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String s = "aaabb";
        int k = 3;
        int ret = longestSubstring(s, k);
        System.out.println(ret);
    }
}
