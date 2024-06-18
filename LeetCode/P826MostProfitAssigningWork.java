package LeetCode;

public class P826MostProfitAssigningWork {

    // difficulty = [2,4,6,8,10]
    // profit = [10,20,30,40,50],
    // worker = [4,5,6,7]

    // Brute Force Approach
    // For worker with ability 4, I go over the difficulty levels that are lesser than or equal to 4 which are 2 and 4
    // the profits for 2 and 4 are 10 and 20 -> So I can take the job with profit 20
    // Similarly, For worker with ability 5, I go over the difficulty levels that are <= 5 which are 2 and 4
    // the profits for 2 and 4 are 10 and 20 -> So I can take the job with profit 20
    // Similarly, For worker with ability 6, I go over the difficulty levels that are <= 6 which are 2,4 and 6
    // the profits for 2,4 and 6 are 10, 20 and 30 -> So I can take the job with profit 30
    // Similarly, For worker with ability 7, I go over the difficulty levels that are <= 7 which are 2,4 and 6
    // the profits for 2,4 and 6 are 10, 20 and 30 -> So I can take the job with profit 30
    // Total 100.
    // Gist is to iterate over worker abilities - find the max profit for the difficulty[i] <= ability[i] - sum all

    public int maxProfitAssignmentBruteForce(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        for ( int i=0; i<worker.length; i++ ) {
            int ability = worker[i];
            int maxProfitForGivenAbility = 0;
            for ( int j=0; j<difficulty.length; j++ ) {
                if ( difficulty[j] <= ability ) {
                    maxProfitForGivenAbility = Math.max(maxProfitForGivenAbility, profit[j]);
                }
            }
            maxProfit += maxProfitForGivenAbility;
        }
        return maxProfit;
    }
}
