package data_structures.arrays;

public class NumberRange {
    public static int[] getRange(int[] a, int key) {
        int[] result = new int[] { -1, -1 };
        result[0] = getIndex(a, key, false);
        if (result[0] != -1) {
            result[1] = getIndex(a, key, true);
        }
        return result;
    }

    private static int getIndex(int[] a, int key, boolean isFirstIndex) {
        int res = -1;
        int start = 0, end = a.length-1;
        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( a[mid] == mid ){
                res = mid;
                if (isFirstIndex){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else if ( a[mid] > key ){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }
}
