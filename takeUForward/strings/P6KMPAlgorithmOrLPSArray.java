package takeUForward.strings;

import java.util.ArrayList;
import java.util.List;

public class P6KMPAlgorithmOrLPSArray {
    public List<Integer> search(String pat, String txt) {
        int [] lps = getLPS(pat+"$"+txt);
        List<Integer> res = new ArrayList<>();
        int m = pat.length(), n = txt.length();
        for ( int i=m+1; i<lps.length; i++){
            if ( lps[i] == m) res.add(i-2*m);
        }
        return res;
    }

    private int[] getLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for ( int i=1; i<n; i++){
            for( int len =1; len<n; len++){
                if ( s.substring(0, len).equals(s.substring(i-len+1, i+1))){
                    lps[i] = len;
                }
            }
        }
        return lps;
    }

}
