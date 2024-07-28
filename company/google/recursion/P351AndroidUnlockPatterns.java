package company.google.recursion;

public class P351AndroidUnlockPatterns {
    boolean[] visited; // To track visited nodes
    int[][] skip; // To track invalid jumps between nodes

    public int numberOfPatterns(int m, int n) {
        // Initialize the skip array for invalid jumps
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2; // 2 is between 1 and 3
        skip[4][6] = skip[6][4] = 5; // 5 is between 4 and 6
        skip[7][9] = skip[9][7] = 8; // 8 is between 7 and 9
        skip[1][7] = skip[7][1] = 4; // 4 is between 1 and 7
        skip[2][8] = skip[8][2] = 5; // 5 is between 2 and 8
        skip[3][9] = skip[9][3] = 6; // 6 is between 3 and 9
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5; // 5 is between 1 and 9, and 3 and 7

        visited = new boolean[10]; // Initialize visited nodes array

        int totalPatterns = 0;
        // Start DFS from 1, 2, and 5 and multiply their results by the symmetrical counts
        totalPatterns += dfs(1, 1, 0, m, n) * 4; // 1, 3, 7, 9 are symmetrical
        totalPatterns += dfs(2, 1, 0, m, n) * 4; // 2, 4, 6, 8 are symmetrical
        totalPatterns += dfs(5, 1, 0, m, n); // 5 is unique
        return totalPatterns;
    }

    private int dfs(int current, int length, int count, int m, int n) {
        // If the current pattern length is within the valid range, increase the count
        if (length >= m) count++;
        // If the current length exceeds the maximum length, return the count
        if (length >= n) return count;

        visited[current] = true; // Mark the current node as visited
        // Try to extend the pattern by visiting next nodes
        for (int next = 1; next <= 9; next++) {
            int jump = skip[current][next];
            // Visit the next node if it's not visited and there's no invalid jump or the jump node has already been visited
            if (!visited[next] && (jump == 0 || visited[jump])) {
                count = dfs(next, length + 1, count, m, n);
            }
        }
        visited[current] = false; // Backtrack: unmark the current node
        return count;
    }
}

/*
1 2 3
4 5 6
7 8 9
 */
