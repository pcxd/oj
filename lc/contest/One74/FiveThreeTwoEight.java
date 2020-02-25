package contest.One74;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FiveThreeTwoEight
{
    public static int[] kWeakestRows(int[][] mat, int k)
    {
        if(mat == null || mat.length == 0)
            return null;

        int height = mat.length;
        int width = mat[0].length;
        List<RowPair> buff = new ArrayList<>();
        for(int i = 0; i < height; i++)
        {
            int soldiers = 0;
            for(int j = 0; j < width; j++)
            {
                if(mat[i][j] == 0)
                    break;
                soldiers++;
            }

            RowPair rp = new RowPair(i, soldiers);
            buff.add(rp);
        }

        buff.sort(new Comparator<RowPair>()
        {
            @Override
            public int compare(RowPair o1, RowPair o2)
            {
                if(o1.soldiers == o2.soldiers)
                    return o1.row - o2.row;
                return o1.soldiers - o2.soldiers;
            }
        });

        int[] ret = new int[k];
        for(int i = 0; i < k && i < buff.size(); i++)
            ret[i] = buff.get(i).row;

        return ret;
    }
}

class RowPair
{
    public int row;
    public int soldiers;

    public RowPair(int row, int soldiers)
    {
        this.row = row;
        this.soldiers = soldiers;
    }
}
