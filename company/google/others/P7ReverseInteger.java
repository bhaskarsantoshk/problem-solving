package company.google.others;

public class P7ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = (x < 0);
        x = Math.abs(x);
        int rev = 0;
        while ( x!= 0){
            int rem = x % 10;
            int temp = rev * 10 + x;
            if ( rev != (temp -x )/10) return 0;
            rev = temp;
            x /= 10;
        }
        return isNegative ? -rev : rev;
    }
}
