package data_structures.strings;

public class PalindromeFinder {
    public static int getAllPalindromesBruteForce ( String s){
        if ( s== null || s.length() == 0) return 0;
        int count = 0;
        for ( int i=0; i<s.length(); i++){
            for (int j=i+1; j<s.length(); j++){
                if ( isPalindrome(s, i, j)){
                    System.out.println(s.substring(i,j+1));
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

    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = getAllPalindromesBruteForce(str);
        System.out.println("Total palindrome substrings: " + count);
    }

    // Better Solution
    public static int getPalindromes ( String s ){
        if ( s == null || s.length() == 0) return 0;
        int count = 0;
        for ( int i =0; i<s.length(); i++){
            count+= getPalindromes(s, i-1, i+1);
            count+= getPalindromes(s, i, i+1);
        }

    }

    private static int getPalindromes(String s, int j, int k) {
        int count = 0;
        for ( ; j>=0 && k<s.length(); j--, k++){
            if ( s.charAt(j) != s.charAt(k)){
                break;
            }
            System.out.println(s.substring(j,k+1));
            count++;
        }
        return count;
    }
}
