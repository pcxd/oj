package lc.medium;

public class EightSevenSeven
{
    public static boolean stoneGame(int[] piles)
    {
        if(piles == null || piles.length < 0)
            return false;

        int oddSum = 0;
        int evenSum = 0;

        for(int i = 0, j = 1; i < piles.length && j < piles.length; i += 2, j += 2)
        {
            oddSum += piles[i];
            evenSum += piles[j];
        }

        return oddSum != evenSum;
    }
}
