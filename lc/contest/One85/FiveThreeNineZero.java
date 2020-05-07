package lc.contest.One85;

import java.util.HashMap;
import java.util.Map;


public class FiveThreeNineZero
{
    public static int minNumberOfFrogs(String croakOfFrogs)
    {
        if(croakOfFrogs == null || croakOfFrogs.isEmpty())
            return 0;

        int ret = 0;
        Map<Character, Integer> croakStatus = new HashMap<>();
        for(char c : croakOfFrogs.toCharArray())
        {
            char prev = getPrevLetter(c);
            if(prev == ' ')
                return -1;
            int prevNum = croakStatus.getOrDefault(prev, 0);
            if(prevNum <= 0)
            {
                if(c != 'c')
                    return -1;
                else
                {
                    ret++;
                    croakStatus.put(prev, 1);
                }
            }

            croakStatus.put(prev, croakStatus.get(prev) - 1);
            croakStatus.put(c, croakStatus.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : croakStatus.entrySet())
            if(entry.getKey() != 'k' && entry.getValue() != 0)
                return -1;

        return ret;
    }

    private static char getPrevLetter(char c)
    {
        char ret;
        switch(c)
        {
            case 'c':
                ret = 'k';
                break;
            case 'r':
                ret = 'c';
                break;
            case 'o':
                ret = 'r';
                break;
            case 'a':
                ret = 'o';
                break;
            case 'k':
                ret = 'a';
                break;
            default:
                ret = ' ';
                break;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        String croakOfFrogs = "croakcroa";
        int ret = minNumberOfFrogs(croakOfFrogs);
        System.out.println(ret);
    }
}
