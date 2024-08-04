package company.google.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class P843GuessTheWord {
    public void findSecretWord(String[] words, Master master) {
        List<String> searchSpace = Arrays.asList(words);
        int trail = 1;
        int maxTrails = 10;
        while ( trail < maxTrails){
            int index = new Random().nextInt(searchSpace.size());
            String currentWord = searchSpace.get(index);
            int matches = master.guess(currentWord);
            List<String> tempSearchSpace = new ArrayList<>();
            for ( String word : searchSpace){
                if ( countMatches(word, currentWord) == matches) tempSearchSpace.add(word);
            }
            searchSpace = tempSearchSpace;
            trail++;
        }

    }

    private int countMatches(String s, String t) {
        if ( s.length() != t.length() ) return 0;
        int count=0;
        for ( int i=0; i<s.length(); i++){
            if ( s.charAt(i) == t.charAt(i)) count++;
        }
        return count;
    }

    interface Master{
        // Backend
        public int guess(String s);
    }
}
