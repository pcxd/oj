package medium;

public class SevenNine
{
    static int[][] next = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int maxCol = 0, maxRow = 0;

    public static boolean exist(char[][] board, String word)
    {
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;

        maxRow = board.length;
        maxCol = board[0].length;

        boolean[][] vis = new boolean[maxRow][maxCol];
        for(int row = 0; row < maxRow; row++)
            for(int col = 0; col < maxCol; col++)
                if(board[row][col] == word.charAt(0))
                {
                    vis[row][col] = true;
                    if(dfs(board, word, vis, row, col, 0))
                        return true;
                    vis[row][col] = false;
                }

        return false;
    }

    private static boolean dfs(char[][] board, String word, boolean[][] vis, int posRow, int posCol,
            int pos)
    {
        if(pos == word.length() - 1)
            return true;

        for(int i = 0; i < next.length; i++)
        {
            int nextRow = posRow + next[i][0];
            int nextCol = posCol + next[i][1];
            if(nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxCol)
                continue;
            if(vis[nextRow][nextCol] || board[nextRow][nextCol] != word.charAt(pos + 1))
                continue;

            vis[nextRow][nextCol] = true;
            if(dfs(board, word, vis, nextRow, nextCol, pos + 1))
                return true;

            vis[nextRow][nextCol] = false;
        }

        return false;
    }


    public static void main(String[] args)
    {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB"; // SEE, ABCB : true, false

        boolean ret = exist(board, word);
        System.out.println(ret);
    }
}
