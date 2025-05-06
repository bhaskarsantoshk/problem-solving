package takeUForward.tries;

public class P2Trie {
    TrieNode root;
    public P2Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
            node.children[c-'a'].prefixCount++;
            node = node.children[c-'a'];
        }
        node.endsWithCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null) return 0;
            node = node.children[c-'a'];
        }
        return node.endsWithCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for ( char c: prefix.toCharArray()){
            if ( node.children[c-'a'] == null) return 0;
            node = node.children[c-'a'];
        }
        return node.prefixCount;
    }

    public void erase(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null) return;
            node.children[c-'a'].prefixCount--;
            node = node.children[c-'a'];
        }
        node.endsWithCount--;
    }

    class TrieNode{
        TrieNode[] children ;
        int endsWithCount;
        int prefixCount;

        TrieNode(){
            this.children = new TrieNode[26];
            this.endsWithCount=0;
            this.prefixCount=0;
        }
    }
}
