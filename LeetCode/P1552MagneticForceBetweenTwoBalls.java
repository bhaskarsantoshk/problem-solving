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


    public static void main(String[] args) {
        int [] position = {1,2,3,4,7};
        int m = 3;
        P1552MagneticForceBetweenTwoBalls obj = new P1552MagneticForceBetweenTwoBalls();
        System.out.println(obj.maxDistance(position, m));

        position = new int[] {5,4,3,2,1,1000000000};
         m = 2;
        System.out.println(obj.maxDistance(position, m));
    }
}
