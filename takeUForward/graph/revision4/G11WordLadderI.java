package takeUForward.graph.revision4;

import java.util.*;

public class G11WordLadderI {
    public int wordLadderLength(String startWord, String targetWord,
                                List<String> wordList) {
        Queue<Word> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> vis = new HashSet<>();

        queue.offer(new Word(startWord, 1));
        vis.add(startWord);

        while (!queue.isEmpty()){
            Word wordObj = queue.poll();
            String word = wordObj.word;
            int steps = wordObj.steps;
            if ( word.equals(targetWord)) return steps;
            char[] wordChar = word.toCharArray();
            for ( int i=0; i<wordChar.length; i++){
                char original = wordChar[i];
                for ( char c='a'; c<='z'; c++){
                    wordChar[i] = c;
                    String newWord = new String(wordChar);
                    if ( dictionary.contains(newWord) && !vis.contains(newWord)){
                        queue.offer(new Word(newWord, steps+1));
                        vis.add(newWord);
                    }
                }
                wordChar[i] = original;
            }
        }
        return 0;
    }

    class Word{
        String word;
        int steps;

        public Word(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
}
