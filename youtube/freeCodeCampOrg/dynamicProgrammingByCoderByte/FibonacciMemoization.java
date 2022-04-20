package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

public class FibonacciMemoization {
    public static long fibonnaciRec( int n){
        if ( n <= 0) return 0;
        if ( n <= 2) return 1;
        return fibonnaciRec(n-1) + fibonnaciRec(n-2);
        // t: O(2^n) , s: O(n)
    }

    public static void main(String[] args){
        System.out.println(fibonnaciRec(6));
        System.out.println(fibonnaciRec(7));
        System.out.println(fibonnaciRec(8));
        //System.out.println(fibonnaciRec(50)); // Takes really long time

        // Memoization
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(50));
    }


    public static long fibonacci( int n){
        long [] memo = new long[n+1];
        return fibonacciMemo( n,memo);
    }

    private static long fibonacciMemo(int n, long[] memo) {
        if ( memo[n] != 0) {
            return memo[n];
        }
        if ( n <= 0){
            return 0;
        }
        if ( n <= 2){
            return 1;
        }
        memo[n] = fibonacciMemo(n-1, memo)+ fibonacciMemo(n-2, memo);
        return memo[n];
    }
}
