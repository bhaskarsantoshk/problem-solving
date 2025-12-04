package takeUForward.recursion.revision4;

import java.util.Scanner;

public class P8Palindrome {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = "MADAM";
        System.out.println(isPalindrome(s, 0));
    }

    private static boolean isPalindrome(String s, int i) {
        if ( i >= s.length()/2) return true;
        if ( s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return isPalindrome(s, i+1);
    }
}
