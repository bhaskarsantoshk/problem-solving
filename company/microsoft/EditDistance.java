package company.microsoft;

public class EditDistance {
    public int minDistance(String A, String B) {
        int dp[][] = new int[A.length()+1][B.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j]= 0;
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1]+1;
                }
                else if(j==0){
                    dp[i][j]= dp[i-1][j]+1;
                }
                else{
                    if(A.charAt(i)== B.charAt(j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.min( Math.min(dp[i-1][j], dp[i][j-1]) , dp[i-1][j-1]) + 1;
                    }
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
