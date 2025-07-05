package takeUForward.strings;

public class P8LongestHappyPrefix {
    public String lps(String s) {
        int [] LPS = computeLPS(s);
        int n = LPS.length;
        return s.substring(0, LPS[n-1]);
    }

    private int[] computeLPS(String s) {
        int n = s.length();
        int [] lps = new int[n];
        for ( int i=1; i<n; i++){
            for ( int len=0; len<=i; len++){
                if ( s.substring(0, i).equals(s.substring(i-len+1, i+1))){
                    lps[i] = len;
                }
            }
        }
        return lps;
    }

    private int[] computeLPSOptimal(String s) {
        int n = s.length();
        int [] lps = new int[n];
        int i=1, j=0;
        while ( i < n){
            if ( s.charAt(i) == s.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            } else {
                while ( j > 0 && s.charAt(i) != s.charAt(j)){
                    j = lps[j - 1];
                }
                if ( s.charAt(i)== s.charAt(j)){
                    lps[i] = j+1;
                    j++;
                }
                i++;
            }
        }
        return lps;
    }
}
