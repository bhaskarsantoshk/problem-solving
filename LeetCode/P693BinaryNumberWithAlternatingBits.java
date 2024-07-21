package LeetCode;

public class P693BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits1(int n) {
        String bits = Integer.toBinaryString(n);
        for ( int i=0; i<bits.length()-1; i++){
            if (bits.charAt(i) == bits.charAt(i+1)) return false;
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        int cur = n % 2;
        n /= 2;
        while ( n > 0){
            if ( cur == n%2) return false;
            cur = n%2;
            n/=2;
        }
        return true;
    }

    public boolean hasAlternatingBits3(int n) {
        n = n ^ (n>>1);
        return ((n & n+1)==0);
    }
}
