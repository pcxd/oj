package lc.contest.One87;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FiveFourZeroZero
{
    public static String destCity(List<List<String>> paths)
    {
        if(paths.size() == 0)
            return "";

        Map<String, Set<String>> buff = new HashMap<>();
        for(List<String> path : paths)
        {
            if(path.size() != 2)
                return "";

            String from = path.get(0);
            String to = path.get(0);
            if(!buff.containsKey(from))
                buff.put(from, new HashSet<>());
            if(!buff.containsKey(to))
                buff.put(to, new HashSet<>());


            buff.get(from).add(to);
        }

        String ret = "";
        for(Map.Entry<String, Set<String>> entry : buff.entrySet())
            if(entry.getValue().size() == 0)
            {
                ret = entry.getKey();
                break;
            }

        return ret;
    }
}
