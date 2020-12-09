package lc.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FourZeroThree
{
    public static boolean canCross(int[] stones)
    {
        if(stones == null || stones.length == 0)
            return false;

        Map<Integer, Integer> idxBuff = new HashMap<>();
        for(int i = 0; i < stones.length; i++)
            idxBuff.put(stones[i], i);

        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i < stones.length; i++)
            dp.add(new HashSet<>());
        dp.get(0).add(1);

        for(int i = 0; i < stones.length; i++)
        {
            int curPos = stones[i];
            for(Integer step : dp.get(i))
            {
                int nextPos = step + curPos;
                if(idxBuff.containsKey(nextPos))
                {
                    int nextIdx = idxBuff.get(nextPos);
                    dp.get(nextIdx).add(step);
                    dp.get(nextIdx).add(step + 1);
                    if(step - 1 > 0)
                        dp.get(nextIdx).add(step - 1);
                }
            }
        }

        return !dp.get(stones.length - 1).isEmpty();
    }


    public static void main(String[] args)
    {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        boolean ret = canCross(stones);
        System.out.println(ret);
    }
}
