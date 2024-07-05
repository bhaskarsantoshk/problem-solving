package company.microsoft;

public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = ( x < 0) ;
        x = Math.abs(x);
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            int temp = rev * 10 + digit;
            if ( (temp - digit)/10 != rev ) return 0;
            rev = temp;
        }
        return negative ? -rev : rev;
    }
}
