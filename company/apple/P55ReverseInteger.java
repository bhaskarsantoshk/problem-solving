package company.apple;

public class P55ReverseInteger {
    public int reverse(int x) {
        int num = Math.abs(x);
        int rev = 0;
        while ( num != 0){
            int rem = num % 10;
            int temp = rev * 10 + rem;
            if ( (temp-rem)/10 != rev ) return 0;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return (x<0)? -rev: rev;
    }

    // 12344
    // 44321
}
