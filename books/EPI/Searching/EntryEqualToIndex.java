package books.EPI.Searching;

import java.util.List;
// distinct integers
public class EntryEqualToIndex {
    public static int searchEntryEqualToIndex(List<Integer> a){
        int start = 0, end = a.size()-1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            int diff = a.get(mid) - mid;
            if ( diff == 0){
                return mid;
            }
            else if (diff > 0){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
