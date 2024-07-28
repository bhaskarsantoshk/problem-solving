package company.google.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P425WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if ( words == null || words.length ==0 || words[0] == null || words[0].isEmpty()) return res;
        for ( String word: words) addToTrie(word, root);
        TrieNode[] rows = new TrieNode[words[0].length()];
        Arrays.fill(rows, root);
        findAllSquares(0, 0, rows, res);
        return res;
    }

    private void findAllSquares(int row, int col, TrieNode[] rows, List<List<String>> res) {
        if ( row == rows.length ){
            List<String> temp = new ArrayList<>(row);
            for ( int i=0; i<row; i++){
                temp.add(rows[i].val);
            }
            res.add(temp);
        } else if ( col <rows.length){
            TrieNode currentRow = rows[row];
            TrieNode currentCol = rows[col];
            for(int i = 0; i < 26; i++){
                if(currentRow.children[i] != null && currentCol.children[i] != null){
                    rows[row] = currentRow.children[i];
                    rows[col] = currentCol.children[i];
                    findAllSquares(row, col + 1, rows, res);
                }
            }
            rows[row] = currentRow;
            rows[col] = currentCol;
        } else{
            findAllSquares(row + 1, row + 1, rows, res);
        }
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String val;
    }

    private TrieNode root = new TrieNode();

    private void addToTrie(String s, TrieNode root){
        for ( int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            if ( root.children[index] == null ){
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.val = s;
    }
}
