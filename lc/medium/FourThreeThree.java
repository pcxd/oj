package medium;

import java.util.HashSet;
import java.util.Set;


public class FourThreeThree
{
    private static char[] GENE = {'A', 'C', 'G', 'T'};

    public static int minMutation(String start, String end, String[] bank)
    {
        if(bank == null || bank.length == 0)
            return -1;

        Set<String> bankSet = new HashSet<>();
        for(String item : bank)
            bankSet.add(item);
        if(!bankSet.contains(end))
            return -1;

        Set<String> level = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        level.add(start);
        while(!level.isEmpty())
        {
            if(level.contains(end))
                return step;

            Set<String> nextLevel = new HashSet<>();
            for(String item : level)
            {
                visited.add(item);
                for(int i = 0; i < item.length(); i++)
                {
                    char[] gene = item.toCharArray();
                    for(int j = 0; j < GENE.length; j++)
                    {
                        gene[i] = GENE[j];
                        String nGene = new String(gene);
                        if(bankSet.contains(nGene) && !visited.contains(nGene))
                            nextLevel.add(nGene);
                    }
                }
            }

            step++;
            level = nextLevel;
        }

        return -1;
    }


    public static void main(String[] args)
    {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int ret = minMutation(start, end, bank);
        System.out.println(ret);
    }
}
