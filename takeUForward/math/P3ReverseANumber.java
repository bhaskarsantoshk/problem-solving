package takeUForward.math;

public class P3ReverseANumber {
    public int reverseNumber(int n) {
        int reverse = 0;
        while ( n > 0){
            reverse = reverse*10+ n % 10;
            n/=10;
        }
        return reverse;
    }
}
