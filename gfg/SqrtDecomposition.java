package gfg;

import java.util.Arrays;


public class SqrtDecomposition
{
    static int[] origArr;
    static int[] block;
    static int blockSize;


    private static void preprocess(int[] input, int n)
    {
        origArr = new int[n];
        blockSize = (int) Math.sqrt(n) + 1;
        block = new int[blockSize];
        Arrays.fill(origArr, 0);
        Arrays.fill(block, 0);

        int blockIdx = -1;
        for(int i = 0; i < input.length; i++)
        {
            origArr[i] = input[i];

            if(i % blockSize == 0)
                blockIdx++;

            block[blockIdx] += origArr[i];
        }
    }

    private static void minPreprocess(int[] input, int start, int end)
    {
        int arrSize = end - start + 1;
        int[] arr = new int[arrSize];
        int blockCnt = (int) Math.sqrt(arrSize) + 1;
        int[] minBlocks = new int[blockCnt];
        Arrays.fill(minBlocks, Integer.MAX_VALUE);

        int blockIdx = -1;
        for(int i = start; i <= end; i++)
        {
            arr[i - start] = input[i];
            if((blockIdx - start) % blockCnt == 0)
                blockIdx++;

            minBlocks[blockIdx] = Math.min(minBlocks[blockIdx], input[i]);
        }
    }

    public static void update(int idx, int val)
    {
        int blockID = idx / blockSize;
        origArr[idx] = val;
        block[blockID] += (val - origArr[idx]);
    }

    public static int query(int l, int r)
    {
        int ret = 0;
        l = Math.max(l, 0);
        r = Math.min(r, origArr.length);
        while(l <= r && l % blockSize != 0 && l != 0)
        {
            ret += origArr[l];
            l++;
        }
        while(l + blockSize <= r)
        {
            ret += block[l / blockSize];
            l += blockSize;
        }
        while(l <= r)
        {
            ret += origArr[l];
            l++;
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[] input = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
        int n = input.length;
        preprocess(input, n);

        System.out.println(query(3, 8));
        System.out.println(query(1, 6));
        update(8, 0);
        System.out.println(query(8, 8));
    }

}
