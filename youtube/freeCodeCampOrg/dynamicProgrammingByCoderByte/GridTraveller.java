package youtube.freeCodeCampOrg.dynamicProgrammingByCoderByte;

public class GridTraveller {
    public static long numberOfPathsRec(int m, int n){
        if ( m == 1 && n == 1) return 1;
        if ( m <= 0 || n <= 0) return 0;
        return numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
    }

    public static long numberOfPaths(int m, int n){
        long[][] memo = new long[m+1][n+1];
        return numberOfPathsMemoized(m, n, memo);
    }

    private static long numberOfPathsMemoized(int m, int n, long[][] memo) {
        if ( memo[m][n] != 0) {
            return memo[m][n];
        }
        if ( m == 1 && n == 1) return 1;
        if ( m <= 0 || n <= 0) return 0;
        memo[m][n] = numberOfPathsMemoized(m-1, n, memo) + numberOfPathsMemoized(m, n-1, memo);
        return memo[m][n];
    }

    public static void main(String[] args){
        System.out.println(numberOfPathsRec(1,1)); // 1
        System.out.println(numberOfPathsRec(2,3)); // 3
        System.out.println(numberOfPathsRec(3,2)); // 3
        System.out.println(numberOfPathsRec(3,3)); // 6
        //System.out.println(numberOfPathsRec(18,18)); // 233606220

        System.out.println(numberOfPaths(1,1)); // 1
        System.out.println(numberOfPaths(2,3)); // 3
        System.out.println(numberOfPaths(3,2)); // 3
        System.out.println(numberOfPaths(3,3)); // 6
        System.out.println(numberOfPaths(18,18)); // 233606220
    }
}
