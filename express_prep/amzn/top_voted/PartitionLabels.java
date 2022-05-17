package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int lastIndex[] = new int[26];
        for ( int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            lastIndex[c-'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for ( int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            max = Math.max(max, lastIndex[c-'a']);
            if ( max == i){
                result.add(max - prev);
                prev = max;
            }
        }
        return result;
    }
}
