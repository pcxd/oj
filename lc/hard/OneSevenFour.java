package hard;

public class OneSevenFour
{
    public static int calculateMinimumHP(int[][] dungeon)
    {
        if(dungeon == null || dungeon.length == 0)
            return 0;

        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] dp = new int[height][width];
        for(int h = 1; h < height; h++)
            dp[h][0] = dp[h-1][0]+dungeon[h][0];
        for(int w = 1; w < width; w++)
            dp[0][w] = dp[0][w-1] + dungeon[0][w];

        for(int h = 1; h < height; h++)
            for(int w = 1; w < width; w++)
                dp[h][w] = Math.max(dp[h-1][w], dp[h][w-1])+dungeon[h][w];

        int ret = dp[height-1][width-1] > 0 ? 1 : Math.abs(dp[height-1][width-1])+1;

        return ret;
    }

    public static void main(String[] args)
    {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int ret = calculateMinimumHP(dungeon);
        System.out.println(ret);
    }
}
