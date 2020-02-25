package hard;


import java.util.Arrays;


public class ThreeSixThree
{
    public static int maxSumSubmatrix(int[][] matrix, int k)
    {
        if(matrix == null)
            return 0;

        int[][] mat = tranMatrix(matrix);
        int height = mat.length;
        int width = mat[0].length;

        int ret = Integer.MIN_VALUE;
        for(int h = 0; h < height; h++)
        {
            int[] arr = new int[width];
            Arrays.fill(arr, 0);
            for(int offset = 0; h + offset < height; offset++)
            {
                for(int i = 0; i < width; i++)
                    arr[i] = arr[i] + mat[h + offset][i];

                int t = 0;
                int[] sum = new int[arr.length];
                for(int i = 0; i < arr.length; i++)
                {
                    t += arr[i];
                    sum[i] = t;
                }

                for(int left = -1; left < sum.length; left++)
                    for(int right = left + 1; right < sum.length; right++)
                    {
                        int tmp = left == -1 ? sum[right] : sum[right] - sum[left];
                        if(tmp <= k)
                            ret = Math.max(ret, tmp);
                    }
            }
        }

        return ret;
    }

    private static int[][] tranMatrix(int[][] matrix)
    {

        int height = matrix.length;
        int width = matrix[0].length;

        if(height > width)
        {
            int[][] ret = new int[width][height];
            for(int i = 0; i < height; i++)
                for(int j = 0; j < width; j++)
                    ret[j][i] = matrix[i][j];

            return ret;
        }

        return matrix;
    }


    public static void main(String[] args)
    {
        int[][] matrix = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        int k = 8;
        int ret = maxSumSubmatrix(matrix, k);
        System.out.println(ret);
    }
}
