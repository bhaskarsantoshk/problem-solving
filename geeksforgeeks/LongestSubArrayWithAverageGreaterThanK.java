package geeksforgeeks;

public class LongestSubArrayWithAverageGreaterThanK {
    public int longestSubArrayWithAverageGreaterThanK(int a[], int k ){
        subtractK(a, k);
        int prefixSum[] = calculatePrefixSumArray(a);
        return maxIndexDiff(prefixSum);
    }

    private int maxIndexDiff(int[] a) {
        int len = a.length;
        int maxDiff;
        int i, j;
        int lMin[]= new int[len];
        int rMax[] = new int[len];
        lMin[0] = a[0];
        rMax[len-1] = a[len-1];

        for( i=1; i<len; i++){
            lMin[i]= Math.min(a[i], lMin[i-1]);
        }
        for( j= len-2; j>=0 ; j--){
            rMax[j]= Math.max(rMax[j+1], a[j]);
        }

        i=0; j=0; maxDiff = -1;
        while ( i<len && j<len){
            if (lMin[i] < rMax[j]){
                maxDiff = Math.max(maxDiff, j-i);
                j= j+1;
            }
            else{
                i= i+1;
            }
        }
        return maxDiff+1;
    }

    private int[] calculatePrefixSumArray(int[] a) {
        int prefixSum[] = new int[a.length];
        for (int i=0; i<a.length; i++){
            if ( i==0){
                prefixSum[i] = a[i];
            }
            else{
                prefixSum[i] = prefixSum[i-1] + a[i];
            }
        }
        return prefixSum;
    }

    private void subtractK(int[] a, int k) {
        for(int i=0; i<a.length; i++){
            a[i]= a[i]-k;
        }
    }
}
