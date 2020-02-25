package contest.One76;

import java.util.ArrayList;
import java.util.List;


public class FiveThreeFourOne
{
    List<Integer> nums;
    List<Integer> products;

    public FiveThreeFourOne()
    {
        nums = new ArrayList<Integer>();
        products = new ArrayList<Integer>();
    }

    public void add(int num)
    {

        if(nums.size() == 0)
            products.add(num);
        else
        {
            products.add(products.get(products.size() - 1) * num);
        }
        nums.add(num);
    }

    public int getProduct(int k)
    {
        int size = products.size() - 1;
        return products.get(size) / products.get(size - k);
    }
}
