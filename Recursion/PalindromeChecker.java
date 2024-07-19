package Recursion;

public class PalindromeChecker {
    public static boolean isPalindrome(String s){
        if ( s.length() == 0 || s.length() == 1){
            return true;
        }
        if ( s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static boolean isPalindrome ( String s, int index){
        if ( index >= s.length()/2) return true;
        if ( s.charAt(index) != s.charAt(s.length()-index-1)) return false;
        return isPalindrome(s, index+1);
    }
}
