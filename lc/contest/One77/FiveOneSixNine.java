package contest.One77;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FiveOneSixNine
{
    public static int daysBetweenDates(String date1, String date2)
    {
        if(date1.isEmpty() || date2.isEmpty())
            return 0;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);

            long diff = Math.abs(d1.getTime() - d2.getTime());
            long days = diff / (24 * 60 * 60 * 1000);

            return (int)days;
        }
        catch(Exception e)
        {
            return 0;
        }
    }


    public static void main(String[] args)
    {
        String date1 = "2019-06-29";
        String date2 = "2019-06-30";
        int ret = daysBetweenDates(date1, date2);
        System.out.println(ret);
    }
}
