package takeUForward.recursion.revision2;

public class P5CheckIfStringIsPalindromeOrNot {
    public boolean palindromeCheck(String s) {
       return palindromeCheck(s, 0, s.length()-1);
    }

    private boolean palindromeCheck(String s, int left, int right) {
        if ( left >= right) return true;
        if ( s.charAt(left) != s.charAt(right)) return false;
        return palindromeCheck(s, left+1, right-1);
    }
}
