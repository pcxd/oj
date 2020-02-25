package medium;

public class SixThree
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int w = 1; w < n; w++)
            dp[0][w] = obstacleGrid[0][w] == 1 ? 0 : dp[0][w - 1];
        for(int h = 1; h < m; h++)
            dp[h][0] = obstacleGrid[h][0] == 1 ? 0 : dp[h - 1][0];

        for(int h = 1; h < m; h++)
            for(int w = 1; w < n; w++)
            {
                if(obstacleGrid[h][w] == 1)
                    dp[h][w] = 0;
                else
                    dp[h][w] = dp[h - 1][w] + dp[h][w - 1];
            }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int[][] grid = {{1, 0}};
        int ret = uniquePathsWithObstacles(grid);
        System.out.println(ret);
    }
}
