package takeUForward.graph.hard_problems;

import java.util.*;

public class WordLadderI {
    public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startWord, 1));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.word;
            int steps = pair.steps;
            if ( word.equals(targetWord)) return steps;
            char wordChar[] = word.toCharArray();
            for ( int i=0; i<word.length(); i++){
                char temp = wordChar[i];
                for ( char c='a'; c<='z'; c++){
                    wordChar[i] = c;
                    String newWord = new String(wordChar);
                    if ( dictionary.contains(newWord)){
                        dictionary.remove(newWord);
                        queue.offer(new Pair(newWord, steps+1));
                    }
                }
                wordChar[i] = temp;
            }
        }
        return 0;
    }

    class Pair{
        String word;
        int steps;
        Pair(){

        }
        Pair(String s, int steps){
            this.word = s;
            this.steps=steps;
        }
    }
}
