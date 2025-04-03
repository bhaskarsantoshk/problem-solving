package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class P26PalindromePartitioning {
    public static List<List<String>> partition(String s) {
       List<List<String>> res = new ArrayList<>();
       generate(s, 0, res, new ArrayList<>());
       return res;
    }

    private static void generate(String s, int index, List<List<String>> res, ArrayList<String> list) {
        if ( index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for ( int i=index; i<s.length(); i++){
            if ( isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                generate(s, i+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while ( left <= right) if ( s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
}
