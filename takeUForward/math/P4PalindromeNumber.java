package takeUForward.math;

public class P4PalindromeNumber {
    public boolean isPalindrome(int n) {
        int rev = reverse(n);
        return n == rev;
    }

    private int reverse(int n) {
        int rev = 0;
        while ( n > 0){
            rev = rev * 10 + n % 10;
            n/=10;
        }
        return rev;
    }
}
