package company.amazon.leetcode;

import java.util.*;

public class P1268SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product: products){
            insert(product, root);
        }
        return search(searchWord, root);
    }

    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> res = new ArrayList<>();
        for ( char c: searchWord.toCharArray()){
            if ( root != null ){
                root = root.sub[c-'a'];
            }
            res.add(root == null ? Arrays.asList() : root.suggestion);
        }
        return res;
    }

    private void insert(String product, Trie root) {
        Trie t = root;
        for ( char c: product.toCharArray()){
            if (t.sub[c-'a'] == null ){
                t.sub[c-'a'] = new Trie();
            }
            t = t.sub[c-'a'];
            t.suggestion.offer(product);
            Collections.sort(t.suggestion);
            if ( t.suggestion.size() > 3) {
                t.suggestion.pollLast();
            }
        }
    }

    class Trie{
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
}
