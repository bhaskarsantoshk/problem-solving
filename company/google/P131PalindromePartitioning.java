package company.google;

import java.util.ArrayList;
import java.util.List;

public class P131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, s.length(), result, new ArrayList<String>());
        return result;
    }

    private void partition(String s, int i, int n, List<List<String>> result, List<String> list) {
        if ( i == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for ( int j=i; j<n; j++){
            if ( isPalindrome(s, i, j)){
                list.add(s.substring(i, j+1));
                partition(s, j+1, n, result, list );
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while ( i< j){
            if ( s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
