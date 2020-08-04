package books.EPI.Searching;

import java.util.List;

public class CyclicSortedArray {
    public static int searchSmallest (List<Integer> A){
        int start = 0, end = A.size()-1;
        while ( start <= end ){
            int mid = start + (end - start)/2;
            if ( A.get(mid) > A.get(end)){
                start = mid+1;
            }
            else{
                // Min will be in (left, mid+1)
                end = mid;
            }
        }
        return start;
    }
}

// GIST: If a[m]>a[n-1] then the min value will be in the range [m+1, n-1]
