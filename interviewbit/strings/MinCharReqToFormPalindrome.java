package interviewbit.strings;

public class MinCharReqToFormPalindrome {
    public int solve(String A) {
        char str[] = A.toCharArray();
        int count =0;
        for ( int i=str.length-1; i>=0; i--){
            if (isPalindrome(str, 0, i)){
               return count;
            }
            count++;
        }
        return count;
    }

    private boolean isPalindrome(char[] str, int start, int end) {
        while ( start < end){
            if ( str[start++] != str[end--]){
                return false;
            }
        }
        return true;
    }
}
