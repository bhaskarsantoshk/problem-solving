package company.google.recursion;
import java.util.ArrayList;
import java.util.List;

public class P212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if ( board == null || board.length == 0) return res;
        TrieNode root = buildTrie(words);
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length;j++){
                dfs(board, i, j, res, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, List<String> res, TrieNode p) {
        if ( i < 0 || i>= board.length || j<0 || j>= board[0].length ) return;
        char c = board[i][j];
        if ( c == '#' || p.children[c-'a'] == null ) return;
        board[i][j] = '#';
        if ( p.children[c-'a'].word != null ){
            res.add(p.children[c-'a'].word);
            p.children[c-'a'].word = null;
        }
        p = p.children[c-'a'];
        dfs( board, i+1, j, res, p);
        dfs( board, i-1, j, res, p);
        dfs( board, i, j+1, res, p);
        dfs( board, i, j-1, res, p);
        board[i][j] = c;
    }


    class TrieNode{
        TrieNode[] children= new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for ( String word: words){
            TrieNode node = root;
            for ( char c: word.toCharArray()){
                if ( node.children[c-'a'] == null ){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = word;
        }
        return root;
    }
}
