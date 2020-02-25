package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OneTwoSeven
{
    public static int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if(wordList.isEmpty() || !wordList.contains(endWord))
            return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();
        Set<String> level = new HashSet<>();

        int step = 1;
        level.add(beginWord);
        while(!level.isEmpty())
        {
            if(level.contains(endWord))
                break;

            Set<String> nLevel = new HashSet<>();
            for(String word : level)
            {
                vis.add(word);
                for(int i = 0; i < word.length(); i++)
                {
                    char[] cArr = word.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        cArr[i] = c;
                        String nWord = new String(cArr);
                        if(wordSet.contains(nWord) && !vis.contains(nWord))
                            nLevel.add(nWord);
                    }
                }
            }

            step++;
            level = nLevel;
        }

        return step;
    }

    public static int ladderLength2(String beginWord, String endWord, List<String> wordList)
    {
        if(wordList.isEmpty())
            return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> forward = new HashSet<>();
        Set<String> backward = new HashSet<>();
        Set<String> visited = new HashSet<>();

        forward.add(beginWord);
        backward.add(endWord);
        int step = 1;

        while(!forward.isEmpty() && !backward.isEmpty())
        {
            for(String word : forward)
                if(backward.contains(word))
                    return step;

            if(forward.size() > backward.size())
            {
                Set<String> t = forward;
                forward = backward;
                backward = t;
            }

            Set<String> nextlevel = new HashSet<>();
            for(String word : forward)
            {
                for(int i = 0; i < word.length(); i++)
                {
                    char[] arr = word.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        arr[i] = c;
                        String nextWord = new String(arr);
                        if(wordSet.contains(nextWord) && !visited.contains(nextWord))
                            nextlevel.add(nextWord);
                    }
                }
            }

            step++;
            forward = nextlevel;
        }

        return 0;
    }


    public static void main(String[] args)
    {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        for(String word : wordArr)
            wordList.add(word);

        int ret = ladderLength2(beginWord, endWord, wordList);
        System.out.println(ret);
    }
}
