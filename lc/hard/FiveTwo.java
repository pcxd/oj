package hard;

public class FiveTwo
{
    public static int totalNQueens(int n)
    {
        if(n <= 0)
            return 0;

        return queueDFS(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }


    private static int queueDFS(int n, int pos, boolean[] visA, boolean[] visB, boolean[] visC)
    {
        if(pos == n)
            return 1;

        int ret = 0;
        for(int i = 0; i < n; i++)
        {
            int idxB = i + pos;
            int idxC = i + n - pos - 1;
            if(!visA[i] && !visB[idxB] && !visC[idxC])
            {
                visA[i] = true;
                visB[idxB] = true;
                visC[idxC] = true;

                int cnt = queueDFS(n, pos + 1, visA, visB, visC);
                ret += cnt;

                visA[i] = false;
                visB[idxB] = false;
                visC[idxC] = false;
            }
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int n = 4;
        int ret = totalNQueens(n);
        System.out.println(n);
    }
}
