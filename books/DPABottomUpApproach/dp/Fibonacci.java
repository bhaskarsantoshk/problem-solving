package books.DPABottomUpApproach.dp;

public class Fibonacci {
    public int fib(int n){
        if ( n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for ( int i=3; i<=n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
