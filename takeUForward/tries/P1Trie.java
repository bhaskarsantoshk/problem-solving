package takeUForward.tries;

public class P1Trie {
    TrieNode root;
    P1Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.isWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null) return false;
            node = node.get(c);
        }
        return node.isWord;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for ( char c: prefix.toCharArray()){
            if ( node.children[c-'a'] == null) return false;
            node = node.get(c);
        }
        return true;
    }
}
