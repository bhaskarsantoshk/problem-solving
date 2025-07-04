package takeUForward.strings;

public class P7ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = reverse(s);
        String str = s + "$" + rev;
        int [] lps = computeLPS(str);
        int num = s.length()- lps[lps.length-1];
        return rev.substring(0, num)+s;
    }

    private int[] computeLPS(String str) {
        int j=0, i=1;
        int n = str.length();
        int []lps = new int[n];
        while ( i < n){
            if (str.charAt(i) == str.charAt(j)) {
                lps[i] = j+1; i++; j++;
            } else {
                while ( j > 0 && str.charAt(i) != str.charAt(j)) {
                    j = lps[j - 1];
                }
                if ( str.charAt(i) == str.charAt(j)) {
                    lps[i] = j+1; j++;
                }
                i++;
            }
        }
        return lps;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
