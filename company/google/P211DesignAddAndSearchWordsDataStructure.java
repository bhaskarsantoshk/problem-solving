package company.google;

public class P211DesignAddAndSearchWordsDataStructure {

    TrieNode root = new TrieNode();

    public void addWord(String word){
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null ){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    public boolean search(String word){
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node){
        if ( word.length() == index ) return node.isWord;
        char c = word.charAt(index);
        if ( c == '.'){
            for ( TrieNode child : node.children){
                if ( child != null && search(word, index+1, child)) return true;
            }
        } else {
           return node.children[c-'a'] != null && search(word, index+1, node.children[c-'a']);
        }
        return false;
    }

    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean isWord = false;
    }
}
