package company.microsoft.others;

public class P277FindTheCelebrity {
    public int findCelebrity(int n) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for ( int i=0; i<n; i++){
            for ( int j=0; j<n; j++){
                if ( i != j && knows(i, j)){
                    indegree[j]++;
                }
                if ( i != j && knows(j, i)){
                    outdegree[j]++;
                }
            }
        }
        for ( int i=0; i<n; i++){
            if ( indegree[i] == n-1 && outdegree[i] == 0) return i;
        }
        return -1;
    }

    private boolean knows(int i, int j) {
        // Just a mock, actual impl is within the Leetcode class
        return true;
    }

    public int findCelebrityOptimized(int n) {
       int candidate = 0;
       for ( int i=0; i<n; i++){
           if ( knows(candidate, i)) candidate = i;
       }
       for ( int i=0; i<n; i++){
           if ( i != candidate && ( knows(candidate, i) || !knows(i, candidate))) return -1;
       }
       return candidate;
    }
}
