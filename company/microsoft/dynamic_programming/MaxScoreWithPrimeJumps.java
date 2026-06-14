package company.microsoft.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You're about to play a game. The game is played as follows:

The game is played with a single pawn on n cells arranged in a single row and numbered from 0 to n-1 from left to right.
Each cell has a value assigned to it.
Whenever the pawn enters a cell, the value of the cell is added to your score.
Initially, your score is 0 and your pawn is standing at cell 0.
In a single move, you can move the pawn right by either 1 cell or p cells where p is a prime number having the least significant digit equal to 3. Remember! You must not place the pawn out of the row.
The game ends after your pawn steps on cell n-1 (the value of this cell is also added to the score). The goal is to maximize the score after the end of the game. What's the maximum possible score you can achieve?

For instance, let n = 5 so we have 5 cells numbered from 0 to 4 and let their values be 0, -10, -20, -30, 50. Then the best we can do is the following: the pawn starts at cell 0 and we can reach cells 1 and 3 from it (reaching cell 1 is possible because advancing to next cell is always allowed provided such cell exists, and reaching cell 3 is possible because advancing the pawn by p cells forward is possible when p is prime ending with digit 3, and 3 is such a prime, so moving the pawn from cell 0 to cell 3 is possible). The better move from these two moves is moving the pawn to cell 1 and only then moving it to cell 4 - advancing by 3 cells forward - and ending the game. By doing that we collect (-10) + 50 coins from cells 1 and 4 respectively ending the game with 40 coins which is the best possible outcome.

Input Format

The first contains a single integer n. After that, n lines follow. The i-th of them contains a single integer cell[i].

Constraints

1 ≤ n ≤ 104
-104 ≤ cell[i] ≤ 104
cell[0] = 0
Output Format

Output simply returns net score when pawn reaches n-1th cell i.e. an integer value.


 */

public class MaxScoreWithPrimeJumps {
    public int maxGameScore(List<Integer> cells){
        int n = cells.size();
        List<Integer> primes = getPrimesEndingIn3( n);
        int [] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return f(cells, 0, primes, n, memo);
    }

    private int f(List<Integer> cells, int i, List<Integer> primes, int n, int[] memo) {
        if ( i >= n) return Integer.MIN_VALUE;
        if ( i == n-1) return cells.get(n-1);
        if ( memo[i] != Integer.MIN_VALUE) return memo[i];
        int ans = Integer.MIN_VALUE;
        int next = f(cells, i+1, primes, n, memo);
        if ( next != Integer.MIN_VALUE ) {
            ans = Math.max(cells.get(i) + next, ans);
        }
        for ( int jump: primes){
            if ( i + jump >= n) break;
            next = f(cells, i + jump, primes, n, memo);
            if (next != Integer.MIN_VALUE) {
                ans = Math.max(ans, cells.get(i) + next);

            }
        }

        return memo[i]= ans;

    }

    private List<Integer> getPrimesEndingIn3( int n) {
        List<Integer> primes = new ArrayList<>();
        for ( int i=3; i<n; i++){
            if ( i % 10 == 3 && isPrime(i) ) primes.add(i);
        }
        return primes;
    }

    private boolean isPrime(int x) {
        if ( x < 2 ) return false;
        for ( int i=2; i*i <=x; i++){
            if ( x % i == 0) return false;
        }
        return true;
    }
}
