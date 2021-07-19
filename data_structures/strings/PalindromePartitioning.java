package data_structures.strings;

public class PalindromePartitioning {
    public int getMinCutsForPalindromes(String s){
        return getMinCutsForPalindromes(s, 0, s.length()-1);
    }

    private int getMinCutsForPalindromes(String s, int start, int end) {
        if ( start >= end || isPalindrome(s, start, end)){
            return 0;
        }
        int minCuts = end-start;
        for ( int i=start; i<=end; i++){
            if (isPalindrome(s, start, i)){
                minCuts = Math.min(minCuts, 1+ getMinCutsForPalindromes(s, i+1, end));
            }
        }
        return minCuts;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
