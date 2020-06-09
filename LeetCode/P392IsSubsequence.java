package LeetCode;

public class P392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i =0, j=0;
        if (s.length() == 0) return true;
        while ( j < t.length()){
            if ( s.charAt(i) == t.charAt(j)){
                i++;
                if ( i == s.length()){
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}
