package hard;

import java.util.ArrayList;
import java.util.List;


public class FiveOne
{
    public static List<List<String>> solveNQueens(int n)
    {
        if(n <= 0)
            return null;

        List<List<String>> ret = new ArrayList<List<String>>();

        dfs(n, new boolean[n], new boolean[2 * n], new boolean[2 * n], 0, new ArrayList<>(), ret);

        return ret;
    }

    private static void dfs(int n, boolean[] visA, boolean[] visB, boolean[] visC, int pos,
            List<Integer> path, List<List<String>> ret)
    {
        if(pos == n)
        {
            ret.add(getResult(n, path));
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(!visA[i] && !visB[i + pos] && !visC[i + n - pos])
            {
                path.add(i);
                visA[i] = true;
                visB[i + pos] = true;
                visC[i + n - pos] = true;

                dfs(n, visA, visB, visC, pos + 1, path, ret);

                path.remove(path.size() - 1);
                visA[i] = false;
                visB[i + pos] = false;
                visC[i + n - pos] = false;
            }
        }
    }

    private static List<String> getResult(int n, List<Integer> path)
    {
        char[][] mat = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                mat[i][j] = '.';

        for(int i = 0; i < path.size(); i++)
            mat[i][path.get(i)] = 'Q';

        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < mat.length; i++)
            ret.add(String.copyValueOf(mat[i]));

        return ret;
    }


    public static void main(String[] args)
    {
        int n = 4;
        List<List<String>> ret = solveNQueens(n);
        System.out.println(ret);
    }
}
