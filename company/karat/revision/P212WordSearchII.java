package company.karat.revision;

import java.util.ArrayList;
import java.util.List;

public class P212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        int n = board.length, m = board[0].length;
        int [][] vis = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                dfs(board, vis, i, j, root, result);
            }
        }
        return result;
    }

    int [][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    private void dfs(char[][] board, int[][] vis, int row, int col, TrieNode node, List<String> result) {
        if ( row < 0 || row>= board.length || col < 0 || col >= board[0].length || vis[row][col] == 1) return;
        char c = board[row][col];
        if ( node.children[c-'a'] == null) return;
        node = node.children[c-'a'];
        if ( node.word != null){
            result.add(node.word);
            node.word = null;
        }
        vis[row][col] = 1;
        for ( int[] dir: dirs){
            int nRow = row+dir[0];
            int nCol = col+dir[1];
            dfs( board, vis, nRow, nCol, node, result);
        }
        vis[row][col] = 0;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for ( String word: words){
            TrieNode node = root;
            for ( char c: word.toCharArray()){
                if ( node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
}
