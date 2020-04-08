package contest.One80;

import java.util.Arrays;


public class FiveThreeFiveSeven
{
    public static void main(String[] args)
    {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);                          // stack becomes [1]
        System.out.println(customStack);
        customStack.push(2);                          // stack becomes [1, 2]
        System.out.println(customStack);
        customStack
                .pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        System.out.println(customStack);
        customStack.push(2);                          // stack becomes [1, 2]
        System.out.println(customStack);
        customStack.push(3);                          // stack becomes [1, 2, 3]
        System.out.println(customStack);
        customStack
                .push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        System.out.println(customStack);
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        System.out.println(customStack);
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(customStack);
        customStack
                .pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(customStack);
        customStack
                .pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println(customStack);
        customStack
                .pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println(customStack);
        customStack.pop();                            // return -1 --> Stack is empty return -1.
        System.out.println(customStack);
    }
}


class CustomStack
{
    int pos;
    int[] data;

    public CustomStack(int maxSize)
    {
        if(data == null || data.length != maxSize)
            data = new int[maxSize];

        Arrays.fill(data, 0);
        this.pos = 0;
    }

    public void push(int x)
    {
        if(pos != data.length)
            data[pos++] = x;
    }

    public int pop()
    {
        int ret = -1;
        if(pos != 0)
            ret = data[--pos];

        return ret;
    }

    public void increment(int k, int val)
    {
        int p = 0;
        while(p < pos && k > 0)
        {
            data[p] += val;
            p++;
            k--;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pos; i++)
            sb.append(data[i]).append(" ");

        return sb.toString();
    }
}
