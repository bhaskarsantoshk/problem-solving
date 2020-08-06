package books.EPI.Searching;

import java.util.List;

public class FirstOccurenceOfK {
    public static int searchFirstOccurenceOfK (List<Integer> a, int key){
        int start = 0, end = a.size()-1;
        int result = -1;
        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( a.get(mid) == key ){
                end = mid-1;
                result = mid;
            }
            else if ( a.get(mid) > key ){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }
}
