package company.microsoft;

import java.util.List;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int start = 0;
        int end = a.size()-1;

        while(start<=end){
            int mid = start + (end - start)/2;
            if (a.get(mid) == b){
                return mid;
            }
            else if(a.get(mid) > a.get(end)){
                if(b >= a.get(start) && b < a.get(mid)){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(a.get(mid) < a.get(end)){
                if(b>a.get(mid) && b<=a.get(end)){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}
