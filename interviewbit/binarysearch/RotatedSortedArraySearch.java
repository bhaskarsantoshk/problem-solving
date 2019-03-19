package interviewbit.binarysearch;

import java.util.List;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int low = 0;
        int high = a.size()-1;

        while (low <= high){
            int mid = low+ (high-low)/2;

            if(a.get(mid) == b){
                return mid;
            }
            // Right is sorted
            else if (a.get(mid) < a.get(high)){
                // Is our target value within right
                if(b > a.get(mid) && b<= a.get(high)){
                    low = mid + 1;
                }
                else{
                    high = mid -1;
                }
            }
            //Left is sorted
            else if(a.get(mid) > a.get(high)){
                // Is our target number within left
                if( b < a.get(mid) && b>= a.get(low)){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                return -1;
            }
        }

        return -1;
    }
}
