package express_prep.amzn.top_voted;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if ( height == null || height.length < 2) return 0;
        int maxArea = 0;
        int begin = 0, end = height.length-1;
        while ( begin < end ){
            maxArea = Math.max(maxArea, Math.min(height[begin], height[end]) * ( end - begin));
            if ( height[begin] < height[end]){
                begin++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
