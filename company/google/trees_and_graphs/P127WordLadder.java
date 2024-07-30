package company.google.trees_and_graphs;

import java.util.*;

public class P127WordLadder {
    /*
Convert the word list to a set for quick lookups.
Use BFS to explore all possible transformations.
Keep track of visited words to avoid cycles.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if ( !wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for ( int i=0; i<size; i++){
                String currentWord = queue.poll();
                if ( currentWord.equals(endWord)) return level;
                char[] chars = currentWord.toCharArray();
                for ( int j=0; j<chars.length; j++){
                    char originalChar = chars[j];
                    for ( char c='a'; c<='z'; c++){
                        if ( c == originalChar) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if ( wordSet.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
