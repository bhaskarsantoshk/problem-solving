package LeetCode;

public class P2285MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        long ans = 0, x=1;
        for ( long i: degree ) ans += i * (x++);
        return ans;
    }
}
