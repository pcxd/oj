package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StockSpanner
{
    private Stack<Integer> s;
    private List<Integer> prices;

    public StockSpanner()
    {
        s = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price)
    {
        prices.add(price);
        while(!s.isEmpty() && prices.get(s.peek()) <= price)
            s.pop();

        int left = s.isEmpty() ? -1 : s.peek();
        int cur = prices.size() - 1;
        s.push(cur);

        return cur - left;
    }


    public static void main(String[] args)
    {
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));
    }
}
