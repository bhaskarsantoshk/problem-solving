class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if ( x < 0) return false;
        int rev = 0;
        int temp =x;
        while (temp!=0){
            if ( rev == Integer.MAX_VALUE/10) return false;
            rev = rev * 10 + temp%10;
            temp = temp/10;
        }
        return rev == x;
    }
}
