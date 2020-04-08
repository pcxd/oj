package contest.One79;

import java.util.HashSet;
import java.util.Set;


public class FiveThreeFiveThree
{
    public static int numTimesAllBlue(int[] light)
    {
        if(light == null || light.length == 0)
            return 0;

        int ret = 0;
        int blueCount = 0;
        int lastBlueIdx = 0;
        Set<Integer> lights = new HashSet<>();
        for(int i = 0; i < light.length; i++)
        {
            int curIdx = light[i];
            lights.add(curIdx);

            if(lastBlueIdx == curIdx - 1)
            {
                int start = curIdx;
                while(start <= light.length && lights.contains(start))
                {
                    lastBlueIdx = start;
                    blueCount++;
                    start++;
                }

                if(blueCount == i + 1)
                    ret++;
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] light = {1, 2, 3, 4, 5, 6};
        int ret = numTimesAllBlue(light);
        System.out.println(ret);
    }
}
