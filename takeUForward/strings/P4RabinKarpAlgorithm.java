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
}
