package LeetCode;

public class P9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int temp =x;
        int result = 0;
        while ( temp != 0){
            int rem = temp % 10;
            int newRes = result * 10 + rem;
            if( (newRes-rem)/10 != result){
                return false;
            }
            result = newRes;
            temp /= 10;
        }
        return result == x;
    }
}
