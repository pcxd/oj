package medium;

public class Trie
{
    /**
     * Initialize your data structure here.
     */

    private TrieNode root;

    public Trie()
    {
        root = new TrieNode('#');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word)
    {
        TrieNode pos = root;
        for(int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(pos.children[idx] == null)
                pos.children[idx] = new TrieNode(word.charAt(i));
            pos = pos.children[idx];
        }

        pos.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word)
    {
        if(word == null || word.length() == 0)
            return true;

        TrieNode pos = root;
        for(int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';
            if(pos.children[idx] == null)
                return false;

            pos = pos.children[idx];
        }

        return pos.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix)
    {
        if(prefix == null || prefix.length() == 0)
            return true;

        TrieNode pos = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            int idx = prefix.charAt(i) - 'a';
            if(pos.children[idx] == null)
                return false;

            pos = pos.children[idx];
        }

        return true;
    }


    public static void main(String[] args)
    {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}


class TrieNode
{
    public char val;
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode()
    {
        this.val = ' ';
        this.isWord = false;
        this.children = new TrieNode[26];
    }

    public TrieNode(char c)
    {
        this();
        this.val = c;
    }
}