package contest.One77;

import java.util.HashSet;
import java.util.Set;


public class FiveOneSevenZero
{
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
    {
        if(n <= 0 || leftChild == null || leftChild.length != n || rightChild == null || rightChild.length != n)
            return false;

        Set<Integer> layer = new HashSet<>();
        Set<Integer> vised = new HashSet<>();

        int cnt = 0;
        layer.add(0);
        while(!layer.isEmpty())
        {
            Set<Integer> nextLayer = new HashSet<>();
            for(Integer node : layer)
            {
                vised.add(node);
                cnt++;

                if(leftChild[node] != -1)
                {
                    if(vised.contains(leftChild[node]) || nextLayer.contains(leftChild[node]))
                        return false;
                    nextLayer.add(leftChild[node]);
                }
                if(rightChild[node] != -1)
                {
                    if(vised.contains(rightChild[node]) || nextLayer.contains(rightChild[node]))
                        return false;
                    nextLayer.add(rightChild[node]);
                }
            }

            layer = nextLayer;
        }

        return cnt == n;
    }


    public static void main(String[] args)
    {
        int n = 6;
        int[] leftChild = {1, -1, -1, 4, -1, -1};
        int[] rightChild = {2, -1, -1, 5, -1, -1};
        boolean ret = validateBinaryTreeNodes(n, leftChild, rightChild);
        System.out.println(ret);
    }
}
