package medium;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SixFourEight
{
    public String replaceWords(List<String> dictionary, String sentence)
    {
        if(dictionary == null || dictionary.isEmpty())
            return sentence;

        Trie trie = new Trie();
        for(String d : dictionary)
            trie.add(d);


        String[] items = sentence.split(" ");
        List<String> prefix = new ArrayList<>();
        for(String item : items)
        {
            String p = trie.searchPrefix(item);
            p = p.isEmpty() ? item : p;
            prefix.add(p);
        }

        return StringUtils.join(prefix, " ");
    }


    public static void main(String[] args)
    {
        SixFourEight sfe = new SixFourEight();
        String[] data = new String[]{"cat", "bat", "rat"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(data));
        String sentence = "the cattle was rattled by the battery";

        String ret = sfe.replaceWords(dictionary, sentence);
        System.out.println(ret);
    }

    class TrieNode
    {
        public String val;
        public TrieNode[] children;
        public boolean isWord;

        TrieNode()
        {
            this.val = "";
            this.children = new TrieNode[26];
            this.isWord = false;
        }

        TrieNode(String val)
        {
            this();
            this.val = val;
        }
    }


    class Trie
    {
        private TrieNode root;

        Trie()
        {
            root = new TrieNode();
        }

        public void add(String str)
        {
            TrieNode pos = root;
            for(int i = 0; i < str.length(); i++)
            {
                int idx = str.charAt(i) - 'a';
                if(pos.children[idx] == null)
                    pos.children[idx] = new TrieNode(str.substring(0, i + 1));
                pos = pos.children[idx];
            }

            pos.isWord = true;
        }

        public String searchPrefix(String s)
        {
            TrieNode pos = root;
            for(int i = 0; i < s.length(); i++)
            {
                int idx = s.charAt(i) - 'a';
                if(pos.children[idx] == null)
                    return "";

                pos = pos.children[idx];

                if(pos.isWord)
                    break;
            }

            return pos.val;
        }
    }
}


