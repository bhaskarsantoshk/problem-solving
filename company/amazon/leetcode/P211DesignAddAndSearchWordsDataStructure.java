package company.amazon.leetcode;

public class P211DesignAddAndSearchWordsDataStructure {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
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
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] word, int index, TrieNode node) {
        if ( index == word.length ) return node.isWord;
        if ( word[index] == '.'){
            for ( int i=0; i<node.children.length; i++){
                if ( node.children[i] != null && match(word, index+1, node.children[i])){
                    return true;
                }
            }
        } else {
            return node.children[word[index]-'a'] != null && match(word, index+1, node.children[word[index]-'a']);
        }
        return false;
    }
}
