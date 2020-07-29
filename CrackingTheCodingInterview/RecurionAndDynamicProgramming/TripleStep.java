package CrackingTheCodingInterview.RecurionAndDynamicProgramming;
import java.util.Arrays;

public class TripleStep {

    //Recursion
    int countWaaysRecursive(int n){
        if(n==1 || n==0){
            return 1;
        }
        else if( n== 2){
            return 2;
        }
        return countWays(n-3)+ countWays(n-2)+countWays(n-1);
    }

    //Memoization
    int countWays(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }
    int countWays(int n, int[] memo){
        if( n < 0){
            return 0;
        }
        else if( n == 0){
            return 1;
        }
        else if(memo[n] > -1){
            return memo[n];
        }
        else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }

    //A bottom up approach
    int countWaysDPBottomUp(int n){
        int res[] = new int [n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for(int i=3; i<=n ; i++){
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }
        return res[n];
    }
}
