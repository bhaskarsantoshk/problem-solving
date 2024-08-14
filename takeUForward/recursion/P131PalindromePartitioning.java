package takeuForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class P131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res  = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(s, 0, path, res);
        return res;
    }

    private void partition(String s, int index, List<String> path, List<List<String>> res) {
        if ( index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for ( int i=index; i<s.length(); i++){
            if ( isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                partition(s, i+1, path, res );
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while ( i < j){
            if ( s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
