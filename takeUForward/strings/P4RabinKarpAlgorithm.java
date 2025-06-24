package takeUForward.strings;

import java.util.ArrayList;
import java.util.List;

public class P4RabinKarpAlgorithm {
    public List<Integer> search(String pat, String txt) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        for ( int i=0; i<=n-m; i++){
            boolean flag = true;
            for ( int j=0; j<m; j++){
                if ( pat.charAt(j) != txt.charAt(i+j)){
                    flag = false;
                    break;
                }
            }
            if ( flag == true) result.add(i);
        }
        return result;
    }

    public List<Integer> searchUsingRabinKarp(String pat, String txt) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        int p = 7, mod = 101;
        int hashPat = 0, hashText=0;
        int pRight =1, pLeft=1;
        for ( int i=0; i<m; i++){
            hashPat = (hashPat+ ((pat.charAt(i)-'a'+1) * pRight)%mod)%mod;
            hashText = ( hashText+((txt.charAt(i)-'a'+1) * pRight) %mod)%mod;
            pRight = ( pRight*p)%mod;
        }

        for ( int i=0; i<=n-m; i++){
            if (hashPat == hashText) {
                if (txt.substring(i, i + m).equals(pat)) result.add(i);
            }
            if ( i < n-m) {
                hashText = (hashText - ((txt.charAt(i) - 'a' + 1) * pLeft) % mod + mod) % mod;
                hashText = (hashText + ((txt.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
                hashPat = (hashPat * p) % mod;
                pLeft = (pLeft * p) % mod;
                pRight = (pRight * p) % mod;
            }
        }
        return result;
    }
}
