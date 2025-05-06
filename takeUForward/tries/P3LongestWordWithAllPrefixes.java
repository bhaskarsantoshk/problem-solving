package takeUForward.tries;

import java.util.List;

public class P3LongestWordWithAllPrefixes {
    TrieNode root = new TrieNode();
    public String completeString(List<String> words) {
        for ( String word: words){
            insert(word);
        }
        String result = "";
        for ( String word: words){
            if ( word.length() < result.length()) continue;
            if ( word.length() == result.length() &&  word.compareTo(result) >0 ) continue;
            if ( checkIfTrieContainsAllPrefixes(word) ) {
                result = word;
            }
        }
        return result.isEmpty() ? "None" : result.toString();
    }

    private boolean checkIfTrieContainsAllPrefixes(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null || !node.children[c-'a'].isWord )  return false;
            node = node.children[c-'a'];
        }
        return node.isWord;
    }

    private void insert(String word) {
        TrieNode node = root;
        for ( char c: word.toCharArray()){
            if ( node.children[c-'a'] == null)  node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    class TrieNode{
        TrieNode[] children ;
        boolean isWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
