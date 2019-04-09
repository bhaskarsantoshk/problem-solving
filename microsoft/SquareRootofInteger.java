package microsoft;

public class SquareRootofInteger {
    public int sqrt(int a) {
        if(a==1){
            return 1;
        }
        int start = 1;
        int end = a/2;
        int result = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid == a/mid){
                return mid;
            }
            else if(mid > a/mid){
                end = mid-1;
            }
            else {
                result = mid;
                start = mid;
            }
        }
        return result;
    }
}
