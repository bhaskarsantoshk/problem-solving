package express_prep.amzn.top_voted;

public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if ( x < 0) {
            x *= -1;
            sign = -1;
        }
        int result = 0;
        while ( x!= 0){
            int rem = x % 10;
            int temp = result * 10 + rem;
            if ( (temp - rem)/10 != result) return 0;
            result = temp;
            x /= 10;
        }
        return sign* result;
    }
}
