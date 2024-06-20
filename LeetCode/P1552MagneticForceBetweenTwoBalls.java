package LeetCode;

import java.util.Arrays;

public class P1552MagneticForceBetweenTwoBalls {
    // Similar to P1482MinimumNumberOfDaysToMakeMBouquets


    // position = [1,2,3,4,7], m = 3
    // min = 1 max = 7 maxgap = 6
    // maxgap comes to 3
    // count = 1
    // count = 2 at index 3
    // count = 3 at index 4
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = position[0];
        int max = position[position.length-1];
        int maxGap = max - min;
        while ( maxGap >= 1){
            int count = 1;
            int index = 0;
            for ( int i=0; i<position.length; i++){
                if ( position[i] -position[index] >= maxGap ){
                    index = i;
                    count++;
                }
            }
            if ( count >= m ){
                return maxGap;
            } else {
                maxGap--;
            }
        }
        return maxGap;
    }

    public int maxDistanceBinarySearch(int[] position, int m) {
        Arrays.sort(position);
        int min = position[0];
        int max = position[position.length-1];
        int maxGap = max - min;
        int start = 1, end = maxGap;
        int ans = -1;
        while ( start <= end){
            int mid = (start + end) / 2;
            if ( possible(position, m, mid)){
               start = mid+1;
               ans = mid;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }

    private boolean possible ( int[] position, int m, int gap ){
        int numOfBalls = 1;
        int index = 0;
        for ( int i=0; i<position.length; i++){
            if (position[i] -position[index] >= gap){
                index = i;
                numOfBalls++;
            }
        }
        return numOfBalls>= m;
    }


    public static void main(String[] args) {
        int [] position = {1,2,3,4,7};
        int m = 3;
        P1552MagneticForceBetweenTwoBalls obj = new P1552MagneticForceBetweenTwoBalls();
        System.out.println(obj.maxDistance(position, m));

        position = new int[] {5,4,3,2,1,1000000000};
         m = 2;
        System.out.println(obj.maxDistance(position, m));

        position = new int[] {1,2,3,4,7};
        m = 3;
        obj = new P1552MagneticForceBetweenTwoBalls();
        System.out.println(obj.maxDistanceBinarySearch(position, m));

        position = new int[] {5,4,3,2,1,1000000000};
        m = 2;
        System.out.println(obj.maxDistanceBinarySearch(position, m));
    }
}
