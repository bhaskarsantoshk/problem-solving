package takeUForward.tries;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;

    TrieNode(){

    }

    TrieNode get(char ch){
        return children[ch-'a'];
    }

    void put (char ch, TrieNode node){
        this.children[ch-'a'] = node;
    }

}
