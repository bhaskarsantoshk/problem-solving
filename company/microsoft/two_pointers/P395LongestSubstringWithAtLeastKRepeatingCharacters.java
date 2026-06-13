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

    public int longestSubstringRecursion(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int l, int r, int k) {
        if ( r - l < k) return 0;
        int[] count = new int[26];
        for ( int i=l; i<r; i++) count[s.charAt(i)-'a']++;
        for ( int i=0; i<26; i++){
            if ( count[i] > 0 & count[i] < k){
                int bad = (char)('a'+i);
                int start = l;
                int ans =0;
                for ( int j=l; j<r; j++){
                    if ( s.charAt(j) ==bad){
                        ans = Math.max(solve(s, start, j, k), ans);
                        start = j+1;
                    }
                }
                ans = Math.max(solve(s, start, r, k), ans);
                return ans;
            }
        }
        return r-l;
    }

    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();

        for ( int targetUnique = 1; targetUnique <=26; targetUnique++){
            int left = 0, right = 0;
            int unique = 0, atleastK=0;
            int[] count = new int[26];
            while ( right < n){
                char c = s.charAt(right);
                if ( count[c-'a'] == 0) unique++;
                count[c-'a']++;
                if ( count[c-'a'] == k) atleastK++;
                right++;
                while ( unique > targetUnique){
                    char d = s.charAt(left);
                    if ( count[d-'a'] == k) atleastK--;
                    count[d-'a']--;
                    if ( count[d-'a'] == 0) unique--;
                    left++;
                }
                if ( unique == targetUnique && unique == atleastK) ans = Math.max(ans, right-left);
            }
        }
        return ans;
    }
}
