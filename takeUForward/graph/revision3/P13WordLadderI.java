package takeUForward.graph.revision3;

import java.util.*;

public class P13WordLadderI {
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for ( String word : wordList ) set.add(word);
        Queue<Word> queue = new LinkedList<>();

        queue.offer(new Word(startWord, 1));

        while ( !queue.isEmpty()){
            Word wordObj = queue.poll();
            char[] wordChar = wordObj.word.toCharArray();
            int steps = wordObj.steps;
            if ( wordObj.word.equals(targetWord)) return steps;

            for (int i=0; i<wordChar.length; i++){
                char temp = wordChar[i];
                for ( char c='a'; c<='z'; c++){
                    wordChar[i] = c;
                    String newWord = new String(wordChar);
                    if ( set.contains(newWord)){
                        set.remove(newWord);
                        queue.offer(new Word(newWord, steps+1));
                    }
                }
                wordChar[i] = temp;
            }
        }
        return 0;
    }

    class Word{
        String word;
        int steps;

        public Word(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    /*
    Complexity:

* Time: O(N * L * 26)
* Space: O(N)
     */
}
