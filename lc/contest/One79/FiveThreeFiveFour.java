package contest.One79;

import java.util.Arrays;


public class FiveThreeFiveFour
{
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime)
    {
        if(n < 1 || manager == null || manager.length != n || informTime == null || informTime.length != n)
            return -1;

        int maxCost = -1;
        int[] cost = new int[n];
        Arrays.fill(cost, -1);
        for(int i = 0; i < informTime.length; i++)
        {
            if(informTime[i] != 0)
                continue;

            int curCost = getCost(manager, informTime, cost, i);
            maxCost = Math.max(maxCost, curCost);
        }

        return maxCost;
    }


    private static int getCost(int[] manager, int[] informTime, int[] cost, int i)
    {
        if(cost[i] != -1)
            return cost[i];
        if(manager[i] == -1)
        {
            cost[i] = 0;
            return cost[i];
        }

        int managerID = manager[i];
        cost[i] = informTime[managerID] + getCost(manager, informTime, cost, managerID);

        return cost[i];
    }


    public static void main(String[] args)
    {
        int n = 15;
        int headID = 0;
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] inforTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        int ret = numOfMinutes(n, headID, manager, inforTime);
        System.out.println(ret);
    }
}
