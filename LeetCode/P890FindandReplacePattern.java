package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P890FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words ){
            if (isMathch(word, pattern)){
                result.add(word);
            }
        }
        return result;
    }

    private boolean isMathch(String word, String pattern) {
        int w[]= new int[26], p[] = new int[26];
        for(int i=0; i< Math.min (word.length(), pattern.length()); i++){
            if (w[word.charAt(i)-'a'] != p[pattern.charAt(i)-'a']){
                return false;
            }
            w[word.charAt(i)-'a'] = p[pattern.charAt(i)-'a'] = i+1;
        }
        return true;
    }
}
