package takeUForward.greedy.revision;

public class P12Candy {
    public static int requiredCandies(int[] students) {
        int n = students.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1; right[n-1] = 1;
        for ( int i=1; i<n; i++){
            if ( students[i] > students[i-1]) left[i] = left[i-1]+1;
            else left[i] =1;
        }
        for ( int i=n-2; i>=0; i--){
            if ( students[i] > students[i+1]) right[i] = right[i+1]+1;
            else right[i]=1;
        }
        int sum = 0;
        for ( int i=0; i<n; i++){
            sum+= Math.max(left[i], right[i]);
        }
        return sum;
    }

    public static int requiredCandiesOptimized(int[] students) {
        int n = students.length;
        int[] left = new int[n];
        left[0] = 1;
        for ( int i=1; i<n; i++){
            if ( students[i] > students[i-1]) left[i] = left[i-1]+1;
            else left[i] =1;
        }
        int cur = 1;
        int sum = Math.max(1, left[n-1]);
        for ( int i=n-2; i>=0; i--){
            if ( students[i] > students[i+1]) cur +=1;
            else cur=1;
            sum+=Math.max(cur, left[i]);
        }
        return sum;
    }

    public static int requiredCandiesBest(int[] students) {
        int n = students.length;
        int i=1;
        int sum =1;
        while ( i < n){
            while ( i < n && students[i] == students[i-1] ){ sum++; i++;}
            int peak =1;
            while (i <n && students[i] > students[i+1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while ( i < n && students[i] < students[i-1]){
                sum += down;
                down++;
                i++;
            }
            if ( down > peak) sum += down-peak;
        }
        return sum;
    }
}
