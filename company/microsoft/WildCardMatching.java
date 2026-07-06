package company.microsoft;

public class WildCardMatching {
    public boolean wildCardRec(String str, String pat) {
        return fRec(str, pat, str.length()-1, pat.length()-1);
    }

    private boolean fRec(String str, String pat, int i, int j) {
        if ( i < 0 && j < 0) return true;
        if ( i >=0 && j < 0) return false;
        if ( i < 0 && j >=0){
            for ( int index=0; index<=j ; index++){
                if ( pat.charAt(index) != '*') return false;
            }
            return true;
        }

        if ( str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?') return fRec(str, pat, i-1, j-1);
        if ( pat.charAt(j) == '*'){
            return fRec(str, pat, i-1, j) || fRec( str, pat, i, j-1);
        }

        return false;
    }

    public boolean wildCard(String str, String pat) {
        int n = str.length(), m = pat.length();
        Boolean[][] memo = new Boolean[n][m];
        return fMemo(str, pat, str.length()-1, pat.length()-1, memo);
    }

    private boolean fMemo(String str, String pat, int i, int j, Boolean[][] memo) {
        if ( i < 0 && j < 0) return true;
        if ( i >=0 && j < 0) return false;
        if ( i < 0 && j >=0){
            for ( int index=0; index<=j ; index++){
                if ( pat.charAt(index) != '*') return false;
            }
            return true;
        }
        if ( memo[i][j] != null ) return memo[i][j];
        if ( str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?') return memo[i][j] = fMemo(str, pat, i-1, j-1,memo);
        if ( pat.charAt(j) == '*'){
            return memo[i][j] = fMemo(str, pat, i-1, j, memo) ||  fMemo( str, pat, i, j-1, memo);
        }

        return memo[i][j] = false;
    }
}
