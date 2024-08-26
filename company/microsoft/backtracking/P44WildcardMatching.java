package company.microsoft.backtracking;

public class P44WildcardMatching {
    public boolean isMatch(String s, String p) {
        int i=0, j=0;
        int m = s.length(), n = p.length();
        int starj = -1, lastmatch = -1;
        while ( i < m){
            if ( j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j)== '?')) {
                i++;
                j++;
            } else if ( j < n && p.charAt(j)=='*'){
                starj = j;
                j++;
                lastmatch = i;
            } else if (starj != -1){
                j = starj+1;
                lastmatch++;
                i = lastmatch;
            } else return false;
        }
        while (p.charAt(j) == '*' && j <n) j++;
        return j == n;
    }
}
