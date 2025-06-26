package takeUForward.strings.revision;

import java.util.ArrayList;
import java.util.List;

public class P4RabinKarpAlgorithm {
    public List<Integer> search(String pat, String txt) {
        List<Integer> answer = new ArrayList<>();
        int hashPat = 0, hashText = 0;
        int n = txt.length(), m = pat.length();
        int pLeft =1, pRight=1;
        int p = 7, mod=101;
        for ( int i=0; i<m; i++){
            hashPat = (hashPat + ((pat.charAt(i)-'a'+1) * pRight)%mod)%mod;
            hashText = (hashText + ((txt.charAt(i)-'a'+1) * pRight)%mod)%mod;
            pRight = (pRight*p)%mod;
        }

        for ( int i=0; i<=n-m; i++){
            if ( hashPat == hashText){
                if(txt.substring(i, i+m).equals(pat)) answer.add(i);
            }
            if ( i < n-m){
                hashText = (hashText-((txt.charAt(i)-'a'+1)* pLeft)%mod + mod)%mod;
                hashText = ( hashText + ((txt.charAt(i+m)-'a'+1)* pRight)%mod)%mod;
                hashPat = (hashPat*p)%mod;
                pLeft = (pLeft*p)%mod;
                pRight = (pRight*p)%mod;

            }
        }
        return answer;
    }
}
