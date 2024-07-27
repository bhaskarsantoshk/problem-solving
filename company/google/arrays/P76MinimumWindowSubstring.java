package company.google.arrays;

public class P76MinimumWindowSubstring {

    // brute force
    // generate all substrings , check if it contains, update min length substring
    // use a map to count the occurrences and additional size variable
    // T= O(TLE/ N^2)

    public String minWindowBruteForce(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for ( int i=0; i<s.length(); i++){
            int[] hash = new int[256];
            int count = 0;
            for ( int j=0; j<t.length(); j++) hash[t.charAt(j)]++;
            for (int j=i; j<s.length(); j++){
                if ( hash[s.charAt(j)] > 0) count++;
                hash[s.charAt(j)]--;
                if ( count == t.length()){
                    if ( minLength > (j-i+1)) {
                        minLength = (j-i+1);
                        startIndex = i;
                        break;
                    }
                }
            }
        }
        return (startIndex >=0 ) ? s.substring(startIndex, startIndex+minLength) : "";
    }
}
