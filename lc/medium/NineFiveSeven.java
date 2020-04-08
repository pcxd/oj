package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class NineFiveSeven
{
    public static int[] prisonAfterNDays(int[] cells, int N)
    {
        if(cells == null || cells.length == 0)
            return new int[0];

        int days = 0;
        Map<Integer, String> prions = new HashMap<>();
        String cur = Arrays.toString(cells);
        prions.put(days, cur);
        int finalIdx = N;
        int[] curCells = cells.clone();
        while(days++ <= N)
        {
            int[] nextCells = new int[curCells.length];
            Arrays.fill(nextCells, 0);
            for(int i = 1; i < nextCells.length - 1; i++)
                nextCells[i] = curCells[i - 1] == curCells[i + 1] ? 1 : 0;


            String prison = Arrays.toString(nextCells);
            if(prions.containsValue(prison))
            {
                int circleStart = -1;
                for(Map.Entry<Integer, String> entry : prions.entrySet())
                    if(entry.getValue().equals(prison))
                        circleStart = entry.getKey();

                finalIdx = (N - circleStart) % (days - circleStart) + circleStart;
                break;
            }

            prions.put(days, prison);
            curCells = nextCells.clone();
        }
        String prison = prions.get(finalIdx);
        String[] strArr = prison.replace("[", "").replace("]", "").split(",");
        int[] ret = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++)
            ret[i] = Integer.parseInt(strArr[i].trim());

        return ret;
    }


    public static void main(String[] args)
    {
        int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
        Integer[] test = {1, 0, 0};
        Integer[] testb = test.clone();
        int N = 1000000000;
        int[] ret = prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.deepToString(test));
        System.out.println(Arrays.deepHashCode(test));
        System.out.println(Arrays.deepHashCode(testb));
    }
}
