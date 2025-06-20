package takeUForward.slidingWindow;

public class P10MinimumWindowSubstring {
    public String minWindow(String s, String t) {
       int n = s.length();
       int m = t.length();
       int minLen = (int)1e9;
       int startIndex=-1;
       for ( int i=0; i<n; i++){
           int []hash = new int[256];
           for ( int j=0; j<m; j++) hash[t.charAt(j)]++;
           int count =0;
           for ( int j=i; j<n; j++){
               char c = s.charAt(j);
               if ( hash[c] > 0) count++;
               hash[c]--;
               if ( count == m) {
                   if ( j-i+1 < minLen){
                       minLen = j-i+1;
                       startIndex = i;
                       break;
                   }
               }
           }
       }
       return startIndex == -1 ? "": s.substring(startIndex, startIndex+minLen);
    }

    public String minWindowOptimal(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minLen = (int)1e9;
        int startIndex=-1;
        int left = 0, right = 0;
        int []hash = new int[256];
        for ( int i=0; i<m; i++) hash[t.charAt(i)]++;
        int count = 0;
        while ( right < n){
            char c = s.charAt(right);
            if ( hash[c] > 0) count++;
            hash[c]--;
            while ( count == m){
                if ( right-left+1 < minLen){
                    minLen = right-left+1;
                    startIndex = left;
                }
                char ch = s.charAt(left);
                hash[ch]++;
                if ( hash[ch] > 0) count--;
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "": s.substring(startIndex, startIndex+minLen);
    }
}
