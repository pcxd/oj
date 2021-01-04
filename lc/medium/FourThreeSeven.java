package medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class FourThreeSeven
{
    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {
        }

        TreeNode(int val)
        {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private static int cnt = 0;

    public static int pathSum(TreeNode root, int sum)
    {
        if(root == null)
            return 0;

        cnt = 0;
        getChildSum(root, sum);

        return cnt;
    }

    private static Map<Integer, Integer> getChildSum(TreeNode node, int sum)
    {
        if(node == null)
            return Collections.emptyMap();

        Map<Integer, Integer> leftMap = getChildSum(node.left, sum);
        Map<Integer, Integer> rightMap = getChildSum(node.right, sum);

        Map<Integer, Integer> ret = new HashMap<>();
        ret.put(node.val, ret.getOrDefault(node.val, 0) + 1);
        for(Map.Entry<Integer, Integer> entry : leftMap.entrySet())
            ret.put(entry.getKey() + node.val,
                    ret.getOrDefault(entry.getKey() + node.val, 0) + entry.getValue());
        for(Map.Entry<Integer, Integer> entry : rightMap.entrySet())
            ret.put(entry.getKey() + node.val,
                    ret.getOrDefault(entry.getKey() + node.val, 0) + entry.getValue());

        for(Map.Entry<Integer, Integer> entry : ret.entrySet())
            if(entry.getKey() == sum)
                cnt += entry.getValue();

        return ret;
    }
}
