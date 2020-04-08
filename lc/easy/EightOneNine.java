package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class EightOneNine
{
    public static String mostCommonWord(String paragraph, String[] banned)
    {
        if(paragraph == null || paragraph.isEmpty())
            return "";

        StringBuilder t = new StringBuilder();
        for(int i = 0; i < paragraph.length(); i++)
            if(Character.isLetter(paragraph.charAt(i)))
                t.append(paragraph.charAt(i));
            else
                t.append(' ');
        paragraph = t.toString().toLowerCase();

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> words = new HashMap<>();
        System.out.println(Arrays.toString(paragraph.trim().split(" ")));
        for(String word : paragraph.trim().split(" "))
        {
            word = word.trim();
            if(word.isEmpty() || bannedSet.contains(word))
                continue;

            int count = words.getOrDefault(word, 0);
            words.put(word, count + 1);
        }

        int max = -1;
        String ret = "";
        for(Map.Entry<String, Integer> entry : words.entrySet())
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                ret = entry.getKey();
            }

        return ret;
    }


    public static void main(String[] args)
    {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        String ret = mostCommonWord(paragraph, banned);
        System.out.println(ret);
    }
}

