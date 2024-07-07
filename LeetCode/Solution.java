package LeetCode.LeetCode;

class P2582PassThePillow {
    public int passThePillow(int n, int time) {
        if ( n > time ) {
            return time+1;
        }
        int passes = time % ( 2 * n -2 );

        if ( passes >= n ){
            passes -= (n-1); // ( 1000) - ( 1000-1) = 1
            return n - (passes);
        } else {
            return passes+1;
        }
    }

    // 1 2 3 4
    // n-1 forward and n-1 backward
    // 5 > n-1 but less than n-1+n-1

    // 100 - 6,12,18,..96
    // 1 2 3
    // n = 1000, time = 10

    // 1 2 3 4 5 6 7 8 9 10
    // 16 - 9 = 7

    // 1000, 10000
    
}
