package takeUForward.tries;

public class P4NumberOfDistinctSubstringsInAString {
    TrieNode root = new TrieNode();
    public int countDistinctSubstring(String s) {
        int count =1;
        for( int i=0; i<s.length(); i++){
            TrieNode node = root;
            for ( int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if ( node.children[c-'a'] == null) {
                    node.children[c-'a'] = new TrieNode();
                    count++;
                }
                node = node.children[c-'a'];
            }
        }
        return count;
    }

    class TrieNode{
        TrieNode [] children = new TrieNode[26];
    }
}
