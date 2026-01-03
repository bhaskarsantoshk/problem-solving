package takeUForward.recursion.revision4;

public class P12CheckIfStringIsPalindromeOrNot {
    public boolean palindromeCheck(String s) {
       return palindromeCheck(s, 0, s.length()-1);
    }

    private boolean palindromeCheck(String s, int start, int end) {
        if ( start >= end) return true;
        if ( s.charAt(start) != s.charAt(end)) return false;
        return palindromeCheck(s, start+1, end-1);
    }
}
