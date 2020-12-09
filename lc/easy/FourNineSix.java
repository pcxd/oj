package lc.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class FourNineSix
{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        if(nums1 == null || nums2 == null || nums1.length > nums2.length)
            return new int[0];

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> buff = new HashMap<>();
        for(int i = nums2.length; i >= 0; i--)
        {
            while(!stack.isEmpty() && nums2[i] > stack.peek())
                stack.pop();

            int val = stack.isEmpty() ? -1 : stack.peek();
            buff.put(nums2[i], val);
            stack.push(nums2[i]);
        }

        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++)
            ret[i] = buff.getOrDefault(nums1[i], -1);

        return ret;
    }
}
