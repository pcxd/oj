package medium;

import java.util.Arrays;
import java.util.LinkedList;


public class SixZero
{
    public static String getPermutation(int n, int k)
    {
        if(n <= 0 || k <= 0)
            return "";

        int[] F = new int[n + 1];
        F[0] = 1;
        for(int i = 1; i < F.length; i++)
            F[i] = i * F[i - 1];

        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 0; i <= n; i++)
            nums.add(i);
        StringBuilder sb = new StringBuilder();

        while(k != 0 && n >= 0)
        {
            int idx = (int) Math.ceil(1.0 * k / F[n - 1]);
            sb.append(nums.get(idx));
            nums.remove(idx);

            k = k % F[n - 1];
            n--;
            if(k == 0)
                for(int i = nums.size() - 1; i > 0; i--)
                    sb.append(nums.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        int n = 4;
        int k = 9;
        String ret = getPermutation(n, k);
        System.out.println(ret);
    }

}
