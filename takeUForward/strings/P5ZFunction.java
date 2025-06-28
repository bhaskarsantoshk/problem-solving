package takeUForward.strings;

import java.util.ArrayList;
import java.util.List;

// Input: text = "xyzabxyzabxyz", pattern = "xyz"
//

public class P5ZFunction {
    public List<Integer> search(String text, String pattern) {
        int [] Z = computeZFunction(pattern+"$"+text);
        // "xyz$xyzabxyzabxyz"
        int n = text.length();
        int m = pattern.length();
        List<Integer> result = new ArrayList<>();
        for ( int i=m+1; i<Z.length; i++){
            if ( Z[i] == m) result.add(i-(m+1));
        }
        return result;
    }

    private int[] computeZFunction(String s) {
        int[] Z = new int[s.length()];
        int n = s.length();
        for ( int i=1; i<n; i++){
            while ( i+Z[i] < n && s.charAt(i+Z[i]) == s.charAt(Z[i])) Z[i]++;
        }
        return Z;
    }


    private int[] computeZFunctionOptimal(String s) {
        int[] Z = new int[s.length()];
        int n = s.length();
        int l = 0, r=0;
        for ( int i=1; i<n; i++){
            if ( i > r) {
                while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) Z[i]++;
                l = i;
                r=i+Z[i]-1;
            } else {
                if ( i+Z[i-l] <= r) Z[i] = Z[i-l];
                else {
                    Z[i] = r-i+1;
                    while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) Z[i]++;
                }
            }
        }
        return Z;
    }
}
