import java.util.*;
import java.lang.*;

class TrieNode
{
    char c;
    TrieNode[] children=new TrieNode[26];
    boolean isWord;

    TrieNode(){}

    TrieNode(char c)
    {
        this.c=c;
    }
}

public class Trie
{
    static TrieNode root;

    Trie()
    {
        root=new TrieNode();
    }

    public static void insert(String s)
    {
        TrieNode node=root;
        for(char c: s.toCharArray())
        {
            if(node.children[c-'a']==null)
                node.children[c-'a']=new TrieNode(c);

            node=node.children[c-'a'];
        }
        node.isWord=true;
    }

    public static boolean searchWord(String s)
    {
        TrieNode node=root;
        for(char c: s.toCharArray())
        {
            if(node.children[c-'a']==null)
                return false;

            node=node.children[c-'a'];
        }
        if(node.isWord)
            return true;
        else
            return false;
    }

    public static boolean searchPrefix(String s)
    {
        TrieNode node=root;
        for(char c: s.toCharArray())
        {
            if(node.children[c-'a']==null)
                return false;

            node=node.children[c-'a'];
        }
        return true;
    }

    public static void main(String args[])
    {
        Trie trie=new Trie();
        trie.insert("ant");
        trie.insert("bat");
        trie.insert("bald");
        trie.insert("ball");

        System.out.println("SearchWord status: "+Boolean.toString(trie.searchWord("ant")));
        System.out.println("SearchWord status: "+Boolean.toString(trie.searchWord("an")));
        System.out.println("SearchPrefix status: "+Boolean.toString(trie.searchPrefix("bal")));
        System.out.println("SearchWord status: "+Boolean.toString(trie.searchWord("bal")));

    }
}
