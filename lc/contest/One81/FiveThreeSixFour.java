package contest.One81;

import java.util.LinkedList;
import java.util.List;


public class FiveThreeSixFour
{
    public static int[] createTargetArray(int[] nums, int[] index)
    {
        if(nums == null || nums.length == 0 || index == null || index.length == 0)
            return new int[0];

        List<Integer> buff = new LinkedList<>();
        for(int i = 0; i < index.length; i++)
            buff.add(index[i], nums[i]);

        int[] ret = new int[buff.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = buff.get(i);

        return ret;
    }
}
