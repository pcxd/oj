package medium;

import java.util.Stack;


public class NineZeroSeven
{
    private static final int MOD = (int) 1e9 + 7;

    public static int sumSubarrayMins(int[] arr)
    {
        if(arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!s.empty() && arr[i] < arr[s.peek()])
            {
                int t = s.pop();
                right[t] = i - 1;
            }

            left[i] = s.empty() ? 0 : s.peek() + 1;
            s.push(i);
        }
        while(!s.empty())
            right[s.pop()] = n - 1;

        long ret = 0;
        for(int i = 0; i < n; i++)
            ret = (ret + (long) arr[i] * (i - left[i] + 1) * (right[i] - i + 1)) % MOD;

        return (int) ret;
    }


    public static void main(String[] args)
    {
        int[] arr = new int[]{11, 81, 94, 43, 3};
        int ret = sumSubarrayMins(arr);
        System.out.println(ret);
    }
}
