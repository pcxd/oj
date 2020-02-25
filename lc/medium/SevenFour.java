package medium;


public class SevenFour
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int h = matrix.length;
        int w = matrix[0].length;

        int left = 0, right = h - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(matrix[mid][w - 1] == target)
                return true;
            else if(matrix[mid][w - 1] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        int row = matrix[left][w - 1] >= target ? left : left + 1;
        left = 0;
        right = w - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        int col = left;

        return matrix[row][col] == target;
    }


    public static void main(String[] args)
    {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 10;
        boolean ret = searchMatrix(matrix, target);
        System.out.println(ret);
    }
}
