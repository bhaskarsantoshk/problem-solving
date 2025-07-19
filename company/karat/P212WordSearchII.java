package company.karat;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P212WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int n = board.length, m = board[0].length;
        List<String> res = new ArrayList<>();
        int[][] vis = new int[n][m];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<m; j++){
                dfs(board, vis, i, j, root, res);
            }
        }
        return res;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    private void dfs(char[][] board, int[][] vis, int i, int j, TrieNode node, List<String> res) {
        char c= board[i][j];
        if ( node.children[c-'a'] == null) return;
        node = node.children[c-'a'];
        if ( node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        vis[i][j] = 1;
        for ( int dir[]: dirs) {
            int nRow = i+dir[0], nCol = j+ dir[1];
            if ( nRow >= 0 && nRow< board.length && nCol >=0 && nCol < board[0].length
            && vis[nRow][nCol] == 0 ) dfs(board, vis, nRow, nCol, node, res);
        }
        vis[i][j] = 0;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for ( String word: words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode{
        TrieNode[] children;
        String word;

        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
}
