package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TowOneTwo
{
    private final static int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int H;
    private static int W;

    public List<String> findWords(char[][] board, String[] words)
    {
        if(board == null || board[0].length == 0)
            return Collections.emptyList();

        H = board.length;
        W = board[0].length;
        Trie trie = new Trie();
        Set<String> ws = new HashSet<>();
        for(String w : words)
        {
            trie.add(w);
            ws.add(w);
        }

        boolean[][] vis = new boolean[H][W];
        Set<String> find = new HashSet<>();
        for(int h = 0; h < H; h++)
        {
            for(int w = 0; w < W; w++)
            {
                vis[h][w] = true;
                String word = String.valueOf(board[h][w]);
                dfs(board, ws, trie, h, w, vis, word, find);

                vis[h][w] = false;
            }
        }

        return new ArrayList<>(find);
    }

    private void dfs(char[][] board, Set<String> ws, Trie trie, int ch, int cw, boolean[][] vis,
            String word, Set<String> ret)
    {
        if(ws.contains(word))
            ret.add(word);

        for(int i = 0; i < next.length; i++)
        {
            int nh = ch + next[i][0];
            int nw = cw + next[i][1];
            if(nh < 0 || nh >= H || nw < 0 || nw >= W)
                continue;

            String tryWord = word + board[nh][nw];
            if(!vis[nh][nw] && trie.isPrefix(tryWord))
            {
                vis[nh][nw] = true;
                dfs(board, ws, trie, nh, nw, vis, tryWord, ret);
                vis[nh][nw] = false;
            }
        }
    }

    private class TrieNode
    {
        public char val;
        public TrieNode[] children;
        public boolean isWord;

        TrieNode(char c)
        {
            this.val = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }


    class Trie
    {
        private TrieNode root;

        Trie()
        {
            root = new TrieNode('#');
        }

        public void add(String s)
        {
            if(s == null || s.isEmpty())
                return;

            TrieNode pos = root;
            for(int i = 0; i < s.length(); i++)
            {
                int idx = s.charAt(i) - 'a';
                if(pos.children[idx] == null)
                    pos.children[idx] = new TrieNode(s.charAt(i));
                pos = pos.children[idx];
            }

            pos.isWord = true;
        }

        public boolean isPrefix(String s)
        {
            if(s == null || s.isEmpty())
                return false;

            TrieNode pos = root;
            for(int i = 0; i < s.length(); i++)
            {
                int idx = s.charAt(i) - 'a';
                if(pos.children[idx] == null)
                    return false;
                pos = pos.children[idx];
            }

            return true;
        }
    }
}
