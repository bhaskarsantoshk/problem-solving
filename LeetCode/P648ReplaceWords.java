package LeetCode;

import java.util.List;

public class P648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        Trie trie = buildTrie(dict);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, Trie root) {
        StringBuilder stringBuilder = new StringBuilder();
        for ( String token: tokens){
            stringBuilder.append(getShortReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    private String getShortReplacement(String token, Trie root) {
        Trie temp = root;
        StringBuilder sb = new StringBuilder();
        for ( char c: token.toCharArray()){
            sb.append(c);
            if ( temp.children[c-'a'] != null ){
                if ( temp.children[c-'a'].word != null ){
                    return sb.toString();
                }
                temp = temp.children[c-'a'];
            }
            else{
                return token;
            }
        }
        return token;
    }

    private Trie buildTrie(List<String> dictionary) {
        Trie root = new Trie(' ');
        for ( String word: dictionary){
            Trie temp = root;
            for ( char c: word.toCharArray()){
                if ( temp.children[c-'a'] == null ){
                    temp.children[c-'a'] = new Trie(c);
                }
                temp = temp.children[c-'a'];
            }
            temp.word = word;
        }
        return root;
    }

    class Trie{
        char c;
        Trie[] children;
        String word;

        public Trie(char c){
            this.c = c;
            this.children = new Trie[26];
            this.word = null;
        }

    }
}
