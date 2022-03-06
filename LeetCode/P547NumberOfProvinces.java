package LeetCode;

public class P547NumberOfProvinces {
    public int findCircleNum(int[][] M) {
        if ( M == null || M.length == 0) return 0;
        int count =0;
        boolean visited[] = new boolean[M.length];
        for ( int cityIndex = 0; cityIndex < M.length; cityIndex++){
            if ( !visited[cityIndex] ){
                visited[cityIndex] = true;
                dfs(M, visited, cityIndex);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, boolean[] visited, int cityIndex) {
        for ( int otherCityIndex = 0; otherCityIndex < m.length; otherCityIndex++){
            if ( m[cityIndex][otherCityIndex] == 1 && !visited[otherCityIndex]) {
                visited[otherCityIndex] = true;
                dfs(m, visited, otherCityIndex);
            }
        }
    }
}
