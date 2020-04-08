package contest.One81;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class FiveOneSevenEight
{
    public static int sumFourDivisors(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        final int MAX = 100000;
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, Set<Integer>> divisors = new HashMap<>();
        for(int num : nums)
        {
            divisors.put(num, new HashSet<>());
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for(int i = 1; i <= MAX; i++)
        {
            for(int j = 1; i * j <= MAX; j++)
            {
                Integer key = i * j;
                if(divisors.containsKey(key))
                    divisors.get(key).add(i);
            }
        }

        int ret = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : divisors.entrySet())
        {
            if(entry.getValue().size() == 4)
            {
                int sum = 0;
                for(Integer d : entry.getValue())
                    sum += d;

                ret += sum * numCount.get(entry.getKey());
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {21, 21};
        int ret = sumFourDivisors(nums);
        System.out.println(ret);
    }
}
