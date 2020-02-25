package medium;

public class OneThreeZeroSix
{
    public static boolean canReach(int[] arr, int start)
    {
        if(arr == null || arr.length == 0)
            return false;

        return dfs(arr, start, new boolean[arr.length], new boolean[arr.length]);
    }

    private static boolean dfs(int[] arr, int pos, boolean[] left, boolean[] right)
    {
        if(arr[pos] == 0)
            return true;

        if(left[pos] && right[pos])
            return false;

        right[pos] = true;
        if(pos+arr[pos] < arr.length)
        {
            if(dfs(arr, pos+arr[pos], left, right))
                return true;
        }

        left[pos] = true;
        if(pos-arr[pos] >= 0)
        {
            if(dfs(arr, pos-arr[pos], left, right))
                return true;
        }

        return false;
    }


    public static void main(String[] args)
    {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        boolean ret = canReach(arr, start);
        System.out.println(ret);
    }
}

