package company.amazon.leetcode;

public class P828CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public int uniqueLetterString(String s) {
        int contrib[] = new int[128];
        int lastPosition[] = new int[128];
        int res = 0;
        for ( int i=0; i< s.length(); i++){
            int curChar = s.charAt(i);
            int totalNumOfSubstrEndingHere = i+1;
            contrib[curChar] = totalNumOfSubstrEndingHere - lastPosition[curChar];
            int cur = 0;
            // TODO: Needs micro optimization
            for ( int j=0;j<128; j++){
                res += contrib[j];
            }
            res+= cur;
            lastPosition[curChar] = i+1;
        }
        return res;
    }
}
