package LeetCode;

public class P2182ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int [] freq = new int[26];
        for ( char c: s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder res = new StringBuilder();

        int index = 25;
        while ( index >= 0){
            if ( freq[index] <= 0 ){
                index--;
                continue;
            }
            int use = Math.min(freq[index], repeatLimit);
            for ( int i=0; i<use; i++){
                res.append((char)('a'+index));
            }
            freq[index]-=use;
            if ( freq[index] > 0){
                int nextIndex = index-1;
                while(nextIndex >=0 && freq[nextIndex] == 0) nextIndex--;
                if ( nextIndex < 0) break;
                res.append((char) ('a'+nextIndex));
                freq[nextIndex]--;
            }
        }
        return res.toString();
    }
}
