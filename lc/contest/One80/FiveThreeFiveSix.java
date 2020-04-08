package contest.One80;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FiveThreeFiveSix
{
    public static List<Integer> luckyNumbers(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0)
            return Collections.emptyList();

        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
        {
            int min = 0;
            for(int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j] < matrix[i][min])
                    min = j;

            int max = i;
            for(int k = 0; k < matrix.length; k++)
                if(matrix[k][min] > matrix[i][min])
                    max = k;

            if(matrix[i][min] == matrix[max][min])
                ret.add(matrix[i][min]);
        }

        return ret;
    }


    public static void main(String[] args)
    {
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        List<Integer> ret = luckyNumbers(matrix);
        System.out.println(ret);
    }
}
