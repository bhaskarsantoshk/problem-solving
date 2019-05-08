package LeetCode;

public class P62UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        //return uniquePaths(m-1, n)+uniquePaths(m, n-1);
        int dp[][] = new int[m][n];
        dp[0][0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(i==0){
                    dp[i][j]=1;
                }
                else if(j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
