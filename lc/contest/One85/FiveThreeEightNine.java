package lc.contest.One85;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class FiveThreeEightNine
{
    public static List<List<String>> displayTable(List<List<String>> orders)
    {
        if(orders == null || orders.isEmpty())
            return Collections.emptyList();

        List<List<String>> ret = new ArrayList<>();

        Set<String> foods = new TreeSet<>();
        Map<Integer, Map<String, Integer>> newOrders = new TreeMap<>();

        for(List<String> order : orders)
        {
            if(order.size() != 3)
                return Collections.emptyList();

            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            foods.add(food);
            if(!newOrders.containsKey(table))
                newOrders.put(table, new HashMap<>());

            newOrders.get(table).put(food, newOrders.get(table).getOrDefault(food, 0) + 1);
        }

        List<String> foodItems = new ArrayList<>();
        foodItems.add("Table");
        foodItems.addAll(foods);
        ret.add(foodItems);

        for(Map.Entry<Integer, Map<String, Integer>> order : newOrders.entrySet())
        {
            List<String> newOrder = new ArrayList<>();
            String table = Integer.toString(order.getKey());
            newOrder.add(table);

            for(int i = 1; i < foodItems.size(); i++)
            {
                int num = order.getValue().getOrDefault(foodItems.get(i), 0);
                newOrder.add(Integer.toString(num));
            }

            ret.add(newOrder);
        }

        return ret;
    }

    public static void main(String[] args)
    {

    }
}
