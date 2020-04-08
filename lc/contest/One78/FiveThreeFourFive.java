package contest.One78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FiveThreeFourFive
{
    public static String rankTeams(String[] votes)
    {
        if(votes == null || votes.length == 0)
            return "";

        int teamSize = votes[0].length();
        Map<Character, Team> buff = new HashMap<>();
        for(String vote : votes)
        {
            for(int i = 0; i < vote.length(); i++)
            {
                if(!buff.containsKey(vote.charAt(i)))
                {
                    Team t = new Team();
                    t.name = vote.charAt(i);
                    t.rank = new int[teamSize];
                    Arrays.fill(t.rank, 0);

                    buff.put(t.name, t);
                }

                buff.get(vote.charAt(i)).rank[i]++;
            }
        }

        List<Team> teams = new ArrayList<>();
        teams.addAll(buff.values());
        teams.sort(new Comparator<Team>()
        {
            @Override
            public int compare(Team t1, Team t2)
            {
                int teamSize = t1.rank.length;
                for(int i = 0; i < teamSize; i++)
                {
                    if(t1.rank[i] == t2.rank[i])
                        continue;

                    return t2.rank[i] - t1.rank[i];
                }

                return t1.name - t2.name;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < teams.size(); i++)
            sb.append(teams.get(i).name);

        return sb.toString();
    }


    public static void main(String[] args)
    {
        String[] votes = {"M", "M", "M", "M"};
        String ret = rankTeams(votes);
        System.out.println(ret);
    }
}


class Team
{
    public char name;
    public int[] rank;
}
