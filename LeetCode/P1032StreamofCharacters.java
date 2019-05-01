package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P1032StreamofCharacters {
    private Trie root = null;
    private Queue<Trie> queue = null;
    class Trie{
        boolean isWord;
        Trie[] children;
    }

    public P1032StreamofCharacters(String[] words) {
        root = new Trie();
        if (words != null ){
            for (String word: words){
                addToTrie(word, root);
            }
        }
        queue = new LinkedList<>();
        queue.offer(root);
    }

    private void addToTrie(String word, Trie base) {
        Trie node = base;
        for(char c : word.toCharArray() ){
            if ( node.children == null ){
                node.children = new Trie[26];
            }
            if(node.children[c-'a'] == null ){
                node.children[c-'a'] = new Trie();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;

    }
    public boolean  query(char letter){
        boolean exists = false;
        int size = queue.size();

        for(int i=0; i<size ; i++){
            Trie prev = queue.poll();

            if( prev.children != null ){
                Trie node = prev.children[letter-'a'];
                if(node != null ){
                    if(node.isWord){
                        exists = true;
                    }
                    queue.offer(node);
                }
            }
        }
        queue.offer(root);
        return exists;
    }
}
