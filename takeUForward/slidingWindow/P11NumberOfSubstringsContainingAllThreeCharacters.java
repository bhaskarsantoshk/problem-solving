package takeUForward.slidingWindow;

import java.util.Arrays;

public class P11NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
       int result = 0;
       int n = s.length();
       for ( int i=0; i<n; i++){
           int []hash = new int[3];
           for ( int j=i; j<n; j++){
               char c = s.charAt(j);
               hash[c-'a']=1;
               if ( hash[0]+hash[1]+hash[2] == 3) {
                   result ++;
               }
           }
       }
       return result;
    }

    public int numberOfSubstringsBetter(String s) {
        int result = 0;
        int n = s.length();
        for ( int i=0; i<n; i++){
            int []hash = new int[3];
            for ( int j=i; j<n; j++){
                char c = s.charAt(j);
                hash[c-'a']=1;
                if ( hash[0]+hash[1]+hash[2] == 3) {
                    result += (n-j);
                    break;
                }
            }
        }
        return result;
    }

    public int numberOfSubstringsOptimal(String s) {
        int result = 0;
        int n = s.length();
        int []lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        for ( int i=0; i<n; i++){
            lastSeen[s.charAt(i)-'a'] = i;
            result += 1+ Math.max(Math.max(lastSeen[0], lastSeen[1]), lastSeen[2]);
        }
        return result;
    }
}

