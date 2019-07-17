package LeetCode;

public class P10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if ( s== null || p == null ){
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean [][] M = new boolean[m+1][n+1];
        M[0][0] = true;

        // Check for Pattern #*#*#* ... etc.
        for ( int j= 2; j< n+1; j+=2 ){
            if ( p.charAt(j-1) == '*' && M[0][j-2]){
                M[0][j] = true;
            }
        }
        for ( int i=1; i<m+1; i++){
            for ( int j= 1; j < n+1; j++ ) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if (curP == '.' || curP == curS) {
                    M[i][j] = M[i - 1][j - 1];
                } else if (curP == '*') {
                    char preCurP = p.charAt(j - 2);
                    if (preCurP != '.' && preCurP != curS) {
                        M[i][j] = M[i][j - 2];
                    } else {
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                    }
                }
            }
        }
        return M[m][n];
    }
    public static void main ( String[] args){
        P10RegularExpressionMatching obj = new P10RegularExpressionMatching();
        System.out.println(obj.isMatch("aa", "a*"));
    }
}

//        Pattern pattern = Pattern.compile(p);
//        Matcher matcher = pattern.matcher(s);
//        return matcher.matches();
//        return Pattern.matches(p,s);
//        return Pattern.compile(p).matcher(s).matches();
