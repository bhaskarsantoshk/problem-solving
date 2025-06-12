package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P35LongestStringChain {
    public int longestStringChain(String[] words) {
        Arrays.sort(words, (a,b)-> b.length()-a.length());
        int n = words.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for ( int i=0; i<n; i++){
            for ( int j=0; j<=i-1; j++){
                if ( checkIfpossible(words[i], words[j]) && 1+dp[j] > dp[i]){
                    dp[i] = 1+ dp[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean checkIfpossible(String word1, String word2) {
        if ( word1.length() != word2.length() + 1) return false;
        int index1= 0;
        int index2 = 0;
        while ( index1 < word1.length()){
            if ( index2 < word2.length() && word1.charAt(index1) == word2.charAt(index2)){
                index1++;
                index2++;
            } else {
                index1++;
            }
        }
        if ( index1 == word1.length() && index2 == word2.length()) return true;
        return false;
    }
}
