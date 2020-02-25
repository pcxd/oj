package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OneTwoSix
{
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        List<List<String>> ret = new ArrayList<>();
        if(wordList.isEmpty() || !wordList.contains(endWord))
            return ret;

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        List<String> start = new ArrayList<>();
        start.add(beginWord);
        Set<List<String>> level = new HashSet<>();
        level.add(start);

        int minSize = -1;
        while(!level.isEmpty())
        {
            Set<List<String>> nextLevel = new HashSet<>();
            for(List<String> path : level)
            {
                String lastWord = path.get(path.size() - 1);
                visited.add(lastWord);
                if(minSize != -1 || lastWord.equals(endWord))
                {
                    minSize = path.size();
                    continue;
                }

                for(int i = 0; i < lastWord.length(); i++)
                {
                    char[] cArr = lastWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        cArr[i] = c;
                        String nextWord = new String(cArr);
                        if(wordSet.contains(nextWord) && !visited.contains(nextWord))
                        {
                            List<String> nextPath = new ArrayList<>(path);
                            nextPath.add(nextWord);
                            nextLevel.add(nextPath);
                        }
                    }
                }
            }
            if(minSize != -1)
                break;
            level = nextLevel;
        }

        if(minSize != -1)
            for(List<String> path : level)
                if(path.get(path.size() - 1).equals(endWord))
                    ret.add(new ArrayList<>(path));

        return ret;
    }


    public static void main(String[] args)
    {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = new ArrayList<>();
        for(String word : wordArr)
            wordList.add(word);

        List<List<String>> ret = findLadders(beginWord, endWord, wordList);
        System.out.println(ret);
    }

}

