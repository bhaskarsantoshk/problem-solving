package takeUForward.graph;

import java.util.*;

public class WordLadderI {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
       Set<String> dictionary = new HashSet<>(List.of(wordList));
       int level = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(startWord);
        while ( !q.isEmpty()){
            int size = q.size();
            for ( int k=0; k<size; k++) {
                String word = q.poll();
                if ( word.equals(targetWord)) return level;
                char[] wordArr = word.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char originalChar = wordArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[i] = c;
                        String newWord = new String(wordArr);
                        if (dictionary.contains(newWord)) {
                            q.offer(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    wordArr[i] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
