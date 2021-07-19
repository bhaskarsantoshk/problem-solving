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

    public int getMinCutsForPalindromeDP (String s){
        Integer[][] memo = new Integer[s.length()+1][s.length()+1];
        Boolean[][] memoPalindrome = new Boolean[s.length()+1][s.length()+1];
        return getMinCutsForPalindromeDP(memo, memoPalindrome, s, 0, s.length()-1);
    }

    private int getMinCutsForPalindromeDP(Integer[][] memo, Boolean[][] memoPalindrome, String s, int start, int end) {
        if (start >= end || isPalindromeDP(memoPalindrome,s, start, end)){
            return 0;
        }
        if ( memo[start][end] == null ){
            int minCuts = end-start;
            for ( int i=start; i<=end; i++){
                if ( isPalindrome(s, start, i)){
                    minCuts = Math.min(minCuts, 1+ getMinCutsForPalindromeDP(memo, s, i=1, end));
                }
            }
            memo[start][end] = minCuts;
        }
        return memo[start][end];
    }

    private boolean isPalindromeDP(Boolean[][] memoPalindrome, String s, int start, int end) {
        if ( memoPalindrome[start][end] == null ){
            memoPalindrome[start][end] = true;
            int left = start, right = end;
            while ( left < end){
                if(s.charAt(left++) != s.charAt(right--)) {
                    memoPalindrome[left][right]=false;
                    break;
                }
                if(left < end && memoPalindrome[left][right] != null) {
                    memoPalindrome[start][end] = memoPalindrome[left][right];
                    break;
                }
            }
        }
        return memoPalindrome[start][end];
    }
}
