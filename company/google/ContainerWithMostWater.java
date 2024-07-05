package company.google;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int maxArea = 0;
        while (start < end ){
            maxArea = Math.max(maxArea, Math.min(height[start], height[end])* (end -start));
            if ( height[start] < height[end]) start ++;
            else end --;
        }
        return maxArea;
    }
}
