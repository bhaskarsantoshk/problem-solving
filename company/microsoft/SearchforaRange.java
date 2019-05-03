package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SearchforaRange {
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(indexOfKey(a, b, true));
        result.add(indexOfKey(a,b,false));
    return result;
    }

    private Integer indexOfKey(List<Integer> a, int key, boolean isFirstIndex) {
     int start = 0;
     int end = a.size()-1;
     int result = -1;
     while(start< end){
         int mid = start + (end-start)/2;
         if(a.get(mid)== key){
             if(isFirstIndex){
                 end = mid-1;
             }
             else{
                 start = mid+1;
             }
             result = mid;
         }
         else if(a.get(mid) > key){
             end = mid-1;
         }
         else{
             start = mid+1;
         }
     }

     return result;
    }
}
