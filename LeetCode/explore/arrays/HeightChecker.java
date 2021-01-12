package LeetCode.explore.arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int count[] = new int[1000];
        for ( int height: heights){
            count[height]++;
        }
        int res = 0;
        int currentHeight = 0;
        for ( int i=0; i< heights.length ; i++){
            while ( count[currentHeight] == 0){
                currentHeight++;
            }
            if ( currentHeight != heights[i]){
                res++;
            }
            count[currentHeight]--;
        }
        return res;
    }

}