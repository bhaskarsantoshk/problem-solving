package company.amazon.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)){
            Set<String> nextLevel = new HashSet<>();
            for ( String each: reached){
                for ( int i=0; i<each.length(); i++){
                    char [] str = each.toCharArray();
                    for ( char c= 'a'; c<='z'; c++){
                        str[i] = c;
                        String word = new String(str);
                        if ( dictionary.contains(word)){
                            nextLevel.add(word);
                            dictionary.remove(word);
                        }
                    }
                }
            }
            distance++;
            if ( nextLevel.size() == 0){
                return 0;
            }
            reached = nextLevel;
        }
        return distance;
    }
}
