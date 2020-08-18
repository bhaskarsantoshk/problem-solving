package books.EPI.Strings;

public class Palindrome {
    public static boolean isPalindromic(String s){
        int i=0, j=s.length()-1;
        while ( i!= j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
