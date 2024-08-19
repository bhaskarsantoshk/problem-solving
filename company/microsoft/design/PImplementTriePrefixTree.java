package company.microsoft.design;

public class PImplementTriePrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    TrieNode root;
    public PImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null ){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for ( char c : word.toCharArray()){
            if ( node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for ( char c : prefix.toCharArray()){
            if ( node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
