package company.google.arrays;

import java.util.HashMap;
import java.util.Map;

public class P76MinimumWindowSubstring {

    // brute force
    // generate all substrings , check if it contains, update min length substring
    // use a map to count the occurrences and additional size variable
    // T= O(TLE/ N^2)

    public String minWindowBruteForce(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for ( int i=0; i<s.length(); i++){
            int[] hash = new int[256];
            int count = 0;
            for ( int j=0; j<t.length(); j++) hash[t.charAt(j)]++;
            for (int j=i; j<s.length(); j++){
                if ( hash[s.charAt(j)] > 0) count++;
                hash[s.charAt(j)]--;
                if ( count == t.length()){
                    if ( minLength > (j-i+1)) {
                        minLength = (j-i+1);
                        startIndex = i;
                        break;
                    }
                }
            }
        }
        return (startIndex >=0 ) ? s.substring(startIndex, startIndex+minLength) : "";
    }

    public String minWindow(String s, String t) {
        if ( s == null || s.isEmpty() ) return "";
        Map<Character, Integer> targetHash = new HashMap<>();
        for ( char c: t.toCharArray()) targetHash.put(c, targetHash.getOrDefault(c,0)+1);

        int count =0, startIndex = -1, minLength = s.length()+1;
        int left =0;
        for ( int right =0; right<s.length(); right++){
            char c = s.charAt(right);
            if ( targetHash.containsKey(c)) {
                if ( targetHash.get(c) > 0 ) count++;
                targetHash.put(c, targetHash.get(c)-1);
            }
            while ( count == t.length() ){
                if ( minLength > (right-left+1)) {
                    minLength = right-left+1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                // shrink left..right
                if ( targetHash.containsKey(leftChar)) {
                    targetHash.put(leftChar, targetHash.get(leftChar)+1);
                    if ( targetHash.get(leftChar) > 0) count--;
                }
                left++;
            }
        }
        return startIndex >= 0 ? s.substring(startIndex, startIndex+minLength) : "";
    }
}
