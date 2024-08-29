package takeUForward.graph;
import java.util.*;

public class WordLadderII {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        Set<String> dictionary = new HashSet<>(List.of(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();

        // starting word
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(startWord);
        q.add(startPath);

        // currentLevel
        List<String> currentLevel = new ArrayList<>();
        currentLevel.add(startWord);

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        int level = 0;

        while ( !q.isEmpty()){
            ArrayList<String> path = q.poll();
            if ( path.size() > level) {
                level++;
                for ( String word: currentLevel){
                    dictionary.remove(word);
                }
                currentLevel.clear();
            }

            String curWord = path.get(path.size()-1);

            if ( curWord.equals(targetWord)){
                if (result.isEmpty() || result.get(0).size() == path.size() ) result.add(new ArrayList<>(path));
            }

            char[] wordArr = curWord.toCharArray();
            for ( int i=0; i<wordArr.length; i++){
                char originalChar = wordArr[i];
                for ( char c='a'; c<='z'; c++){
                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    if ( dictionary.contains(newWord)){
                        path.add(newWord);
                        q.offer(new ArrayList<>(path));
                        currentLevel.add(newWord);
                        path.remove(path.size()-1);
                    }
                }
                wordArr[i] = originalChar;
            }
        }
        return result;
    }
}
