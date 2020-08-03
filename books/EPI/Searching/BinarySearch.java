package books.EPI.Searching;

import java.util.List;

public class BinarySearch {
    public static int binarySearch(int key, List<Integer> A){
        int start = 0, end = A.size()-1;
        while ( start <= end ){
            //int mid = (start+end)/2;
            int mid = start + (end-start)/2;
            if ( A.get(mid) == key){
                return mid;
            }
            else if ( A.get(mid) < key ){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }
}
