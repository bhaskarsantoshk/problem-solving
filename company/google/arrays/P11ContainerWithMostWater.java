package company.google.arrays;

public class P11ContainerWithMostWater {
    // T = O(N^2) TLE
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for ( int i=0; i<height.length; i++){
            for ( int j=i+1; j<height.length; j++){
                int l = j-i;
                int h = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, l * h);
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0, end = height.length-1;
        while ( start < end ){
            maxArea = Math.max( Math.min(height[end], height[start]) * (end-start), maxArea );
            if ( height[start] <height[end]) start++;
            else end--;
        }
        return maxArea;
    }

}
