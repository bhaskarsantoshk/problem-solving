package company.google;

import java.util.*;

public class P819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(List.of(banned));
        String normalizedParagraph = paragraph.toLowerCase().replaceAll("[!?',;.]"," ");
        String words[] = paragraph.split("//s+");
        Map<String, Integer> frequency = new HashMap<>();
        for ( String word: words) frequency.put(word, frequency.getOrDefault(word,0)+1);
        int mostCommonWordCount = 0;
        String mostCommonWord ="";

        for ( Map.Entry<String, Integer> entry: frequency.entrySet()){
            if ( entry.getValue() > mostCommonWordCount){
                mostCommonWordCount = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }
        return mostCommonWord;
    }
}
