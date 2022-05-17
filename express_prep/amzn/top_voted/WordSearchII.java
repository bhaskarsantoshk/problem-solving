package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if ( board == null || board.length == 0) return result;
        Trie root = buildTrie(words);
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                dfs( board, i , j, result, root);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, Trie p) {
        if ( i <0 || i>=board.length || j<0 || j>=board[0].length){
            return;
        }
        char c = board[i][j];
        if ( c == '#' || p.next[c-'a'] == null ) return;
        board[i][j] = '#';
        if ( p.next[c-'a'].word != null ){
            result.add(p.next[c-'a'].word);
            p.next[c-'a'].word = null;
        }
        p = p.next[c-'a'];
        dfs(board, i+1, j, result, p);
        dfs(board, i, j+1, result, p);
        dfs(board, i-1, j, result, p);
        dfs(board, i, j-1, result, p);
        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for ( String word: words){
            Trie p = root;
            for ( char c: word.toCharArray() ){
                if ( p.next[c-'a'] == null ){
                    p.next[c-'a'] = new Trie();
                }
                p = p.next[c-'a'];
            }
            p.word = word;
        }
        return root;
    }

    class Trie{
        String word;
        Trie[] next = new Trie[26];
    }
}
