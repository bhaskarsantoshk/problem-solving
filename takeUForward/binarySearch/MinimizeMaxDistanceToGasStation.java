package takeUForward.binarySearch;

public class MinimizeMaxDistanceToGasStation {
    public static double MinimiseMaxDistance(int []arr, int K){
        int n = arr.length;
        int[] howMany = new int[n];

        for ( int gas=1; gas<=K; gas++){
            double maxValue = -1;
            int maxIndex = -1;

            for ( int i=0; i<n-1; i++){
                double gap = (double)(arr[i+1]-arr[i])/ (double)(howMany[i]+1);
                if ( maxValue < gap ){
                    maxValue = gap;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }
        double maxAns = -1;
        for ( int i=0; i<n-1; i++){
            maxAns = Math.max( (double)(arr[i+1]-arr[i])/ (double)(howMany[i]+1), maxAns);
        }
        return maxAns;

    }
}
