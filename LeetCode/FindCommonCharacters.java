package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P1002_FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int gc[] = new int[26];
        Arrays.fill(gc, Integer.MAX_VALUE);
        for ( String word: words){
            int []lc = new int[26];
            for ( char c: word.toCharArray()){
                lc[c-'a']++;
            }
            for ( int i=0; i<26; i++){
                gc[i] = Math.min(gc[i], lc[i]);
            }
        }

        List <String> result = new ArrayList<>();
        for (char c='a'; c<='z'; c++){
            while ( gc[c-'a']>0){
                result.add(String.valueOf(c));
                gc[c-'a']--;
            }
        }
        return result;
    }
}
