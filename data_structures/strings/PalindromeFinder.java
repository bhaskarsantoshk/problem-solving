package data_structures.strings;

public class PalindromeFinder {
    public static int getAllPalindromesBruteForce ( String s){
        if ( s== null || s.length() == 0) return 0;
        int count = 0;
        for ( int i=0; i<s.length(); i++){
            for (int j=i+1; j<s.length(); j++){
                if ( isPalindrome(s, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while ( start < end){
            if ( s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
