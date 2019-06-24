package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P688KnightProbabilityinChessboard {
    int[][] direction= {{2,1}, {-2, 1}, {2,-1}, {-2, -1}, {1,2}, {1,-2}, {-1,2},{-1,-2}};
    Map<String, Double> memo = new HashMap<>();

    public double knightProbability(int N, int K, int r, int c) {
        if ( outOfBoundary(N, r, c)){
            return 0;
        }
        if ( K == 0){
            return 1;
        }
        String key = K+","+r+","+c;
        if ( memo.containsKey(key)){
            return memo.get(key);
        }
        double result = 0;
        for ( int[] dir: direction){
            int row = r + dir[0];
            int col = c + dir[1];
            result += 0.125 * knightProbability(N, K-1, row, col);
        }
        memo.put(key, result);
        return result;
    }

    private boolean outOfBoundary(int N, int r, int c) {
        return (r<0 || r>= N) || (c <0  || c>= N) ;
    }

    public static void main(String [] args){
        P688KnightProbabilityinChessboard obj = new P688KnightProbabilityinChessboard();
        System.out.println(obj.knightProbability(3, 2, 0, 0));
    }
}
