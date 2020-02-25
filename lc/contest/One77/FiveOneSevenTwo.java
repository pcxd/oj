package contest.One77;

import java.util.ArrayList;
import java.util.List;


public class FiveOneSevenTwo
{
    public static String largestMultipleOfThree(int[] digits)
    {
        if(digits == null || digits.length == 0)
            return "";

        List<Integer> buff = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        for(int d : digits)
        {
            if(d % 3 == 0)
                buff.add(d);
            else if(d % 3 == 1)
                ones.add(d);
            else if(d % 3 == 2)
                twos.add(d);
        }

        ones.sort((Integer o1, Integer o2)->o2 - o1);
        twos.sort((Integer o1, Integer o2)->o2 - o1);

        int onesEnd, twosEnd;
        if(ones.size() % 3 == 2 || twos.size() % 3 == 2)
        {
            onesEnd = ones.size() % 3 == 0 ? Math.max(0, ones.size() - 3) : Math
                    .max(0, ones.size() - (ones.size() % 3));
            twosEnd = ones.size() % 3 == 0 ? Math.max(0, twos.size() - 3) : Math
                    .max(0, twos.size() - (twos.size() % 3));
        }
        else
        {
            onesEnd = ones.size() - (ones.size() % 3);
            twosEnd = twos.size() - (twos.size() % 3);
        }
        buff.addAll(ones.subList(0, onesEnd));
        buff.addAll(twos.subList(0, twosEnd));

        List<Integer> oneLeft = ones.subList(onesEnd, ones.size());
        List<Integer> twoLeft = twos.subList(twosEnd, twos.size());

        for(int i = 0; i < oneLeft.size() && i < twoLeft.size(); i++)
        {
            buff.add(oneLeft.get(i));
            buff.add(twoLeft.get(i));
        }

        buff.sort((o1, o2)->o2 - o1);

        int start = 0;
        for(; start < buff.size() - 1; start++)
            if(buff.get(start) != 0)
                break;
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < buff.size(); i++)
            sb.append(buff.get(i));

        return sb.toString();
    }


    public static void main(String[] args)
    {
        int[] digits = {2, 2, 1, 1, 1};
        String ret = largestMultipleOfThree(digits);
        System.out.println(ret);
    }
}
