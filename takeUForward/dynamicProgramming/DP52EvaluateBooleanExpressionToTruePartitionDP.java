package takeUForward.dynamicProgramming;

import java.util.concurrent.RecursiveTask;

public class DP52EvaluateBooleanExpressionToTruePartitionDP {
    static int MOD = (int)1e9+7;
    public static int evaluateExp(String exp) {
        int n = exp.length();
        return f ( 0, n-1, 1, exp);
    }

    private static int f(int i, int j, int isTrue, String exp) {
        if (i > j) return 0;  // Invalid range
        if (i == j) {
            // Base case: when it's just one character, check if it matches the expected boolean value
            if (isTrue == 1) return (exp.charAt(i) == 'T') ? 1 : 0;
            else return (exp.charAt(i) == 'F') ? 1 : 0;
        }

        int ways = 0;
        // Iterate through operators (placed at odd indices)
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            int leftTrue = f(i, ind - 1, 1, exp);
            int leftFalse = f(i, ind - 1, 0, exp);
            int rightTrue = f(ind + 1, j, 1, exp);
            int rightFalse = f(ind + 1, j, 0, exp);

            if (exp.charAt(ind) == '&') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue % MOD * rightTrue % MOD) % MOD) % MOD;
                } else {
                    ways = (ways + (leftTrue % MOD * rightFalse % MOD) % MOD
                            + (leftFalse % MOD * rightTrue % MOD) % MOD
                            + (leftFalse % MOD * rightFalse % MOD) % MOD) % MOD;
                }
            } else if (exp.charAt(ind) == '|') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue % MOD * rightFalse % MOD) % MOD
                            + (leftTrue % MOD * rightTrue % MOD) % MOD
                            + (leftFalse % MOD * rightTrue % MOD) % MOD) % MOD;
                } else {
                    ways = (ways + (leftFalse % MOD * rightFalse % MOD) % MOD) % MOD;
                }
            } else if (exp.charAt(ind) == '^') {
                if (isTrue == 1) {
                    ways = (ways + (leftTrue % MOD * rightFalse % MOD) % MOD
                            + (leftFalse % MOD * rightTrue % MOD) % MOD) % MOD;
                } else {
                    ways = (ways + (leftTrue % MOD * rightTrue % MOD) % MOD
                            + (leftFalse % MOD * rightFalse % MOD) % MOD) % MOD;
                }
            }
        }
        return ways;
    }

        static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
            // Base case 1: When the start index is greater than the end index, no ways to evaluate.
            if (i > j) {
                return 0;
            }
            // Base case 2: When the start and end indices are the same.
            if (i == j) {
                if (isTrue == 1) {
                    return exp.charAt(i) == 'T' ? 1 : 0;
                } else {
                    return exp.charAt(i) == 'F' ? 1 : 0;
                }
            }

            if (dp[i][j][isTrue] != null) {
                return dp[i][j][isTrue];
            }

            long ways = 0;
            for (int ind = i + 1; ind <= j - 1; ind += 2) {
                long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
                long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp);
                long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
                long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);

                char operator = exp.charAt(ind);
                if (operator == '&') {
                    if (isTrue == 1) {
                        ways = (ways + (lT * rT) % MOD) % MOD;
                    } else {
                        ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                    }
                } else if (operator == '|') {
                    if (isTrue == 1) {
                        ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                    } else {
                        ways = (ways + (lF * rF) % MOD) % MOD;
                    }
                } else {
                    if (isTrue == 1) {
                        ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                    } else {
                        ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                    }
                }
            }

            dp[i][j][isTrue] = ways;
            return ways;
        }

        static int evaluateExpWays(String exp) {
            int n = exp.length();
            Long[][][] dp = new Long[n][n][2]; // dp[i][j][k] stores the number of ways to evaluate the subexpression from index i to j with the result k (0 or 1).
            return (int) evaluateExpressionWays(exp, 0, n - 1, 1, dp);
        }


}
