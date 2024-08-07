package company.google.arrays;

public class P42TrappingRainWater {
    public int trap(int[] height) {
        // for each i ->water =  min ( leftMax, rightMax) - height[i] , height[i] < leftMax and rightMax
        // use prefix and suffix max arrays
        if (height == null || height.length == 0) return 0;
        int prefixMax[] = new int[height.length];
        int suffixMax[] = new int[height.length];
        prefixMax[0] = height[0];
        int n = height.length;
        suffixMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (prefixMax[i] > height[i] && suffixMax[i] > height[i]) {
                total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }
        return total;
    }

    public int trapSpaceOptimized(int[] height) {
        int leftMax = 0, rightMax = 0, total = 0;
        int left = 0, right = height.length-1;

        while ( left < right ){
            if ( height[left] <= height[right]){
                if ( leftMax > height[left]){
                    total += (leftMax-height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if ( rightMax > height[right]){
                    total += ( rightMax-height[right]);
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return total;
    }
}
