package company.atlassian;
import java.util.Arrays;

class P2976MinimumCostToConvertStringI {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Initialize distance matrix with maximum values (infinity)
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0; // The cost to change a character to itself is 0
        }

        // Fill distance matrix with given costs
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dis[from][to] = Math.min(dis[from][to], cost[i]);
        }

        // Use Floyd-Warshall algorithm to find shortest paths between all pairs of characters
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }

        // Calculate the total minimum cost to convert source to target
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE) {
                return -1L; // If there is no valid transformation, return -1
            } else {
                totalCost += dis[c1][c2];
            }
        }

        return totalCost;
    }
}

