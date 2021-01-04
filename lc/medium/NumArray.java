package medium;

public class NumArray
{
    private int[] BIT;
    private int[] arr;

    public NumArray(int[] nums)
    {
        arr = new int[nums.length];
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
        {
            update(i, nums[i]);
            arr[i] = nums[i];
        }
    }

    public void update(int i, int val)
    {
        int inc = val - arr[i];
        arr[i] = val;

        int idx = i + 1;
        while(idx < BIT.length)
        {
            BIT[idx] += inc;
            idx += idx & -idx;
        }
    }

    public int sumRange(int i, int j)
    {
        if(i > j)
            return 0;

        return sumPrefix(j + 1) - sumPrefix(i + 1) + arr[i];
    }

    private int sumPrefix(int i)
    {
        int ret = 0;
        while(i > 0)
        {
            ret += BIT[i];

            i -= i & -i;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0, 2));

        na.update(1, 2);

        System.out.println(na.sumRange(0, 2));
    }
}
