class P121LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 1;
        for ( int i=0; i<arr.length; i++){
            if ( dp.containsKey(arr[i]-difference)){
                dp.put(arr[i], dp.get(arr[i]-difference)+1);
            } else {
                dp.put(arr[i], 1);
            }
            ans = Math.max(ans, dp.get(arr[i]));
        }
        return ans;
    }
}
