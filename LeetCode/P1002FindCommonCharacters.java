package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int global_count[] = new int[26];
        Arrays.fill(global_count, Integer.MAX_VALUE);
        for(String s: A){
            int local_count[]=new int[26];
            for(char c: s.toCharArray()){
                local_count[c-'a']++;
            }
            for(int i=0;i<26;i++){
                global_count[i] = Math.min(local_count[i], global_count[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(char c='a'; c<='z'; c++){
            while(global_count[c-'a']-- > 0){
                result.add(""+c);
            }
        }
        return result;
    }
}
