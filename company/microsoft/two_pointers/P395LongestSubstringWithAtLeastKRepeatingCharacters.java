package company.microsoft.two_pointers;

import java.util.Arrays;

public class P395LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstringBruteForce(String s, int k) {
        if ( s == null || s.isEmpty() || k > s.length() ) return 0;

        int res = 0;
        int[] countMap = new int[26];
        int n = s.length();
        for ( int i =0; i <n; i++ ){
            Arrays.fill(countMap, 0);
            for ( int j =i; j <n; j++){
                char c = s.charAt(j);
                countMap[c-'a']++;
                if ( isValid(countMap, k)) res = Math.max(res, j-i+1);
            }
        }
        return res;
    }

    private boolean isValid(int[] countMap, int k) {
        int chars = 0;
        int charsK = 0;
        for ( int freq: countMap){
            if ( freq > 0) chars++;
            if ( freq >= k) charsK++;
        }
        return charsK == chars;
    }
}
