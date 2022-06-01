package express_prep.amzn.top_voted;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String delim = " ?!',;."+"\"";
        for ( char c: paragraph.toCharArray() ){
            if ( delim.indexOf(c) >= 0){
                String word = sb.toString();
                if ( word.length() > 0){
                    words.add(word.toLowerCase());
                }
                sb = new StringBuilder();
            } else {
                sb.append(c+"");
            }
        }
        if ( sb.toString().length() > 0){
            words.add(sb.toString().toLowerCase());
        }

        Set<String> bannedWords = new HashSet<>(List.of(banned));
        String res = "";
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            if ( !bannedWords.contains(word) ) {
                map.put(word, map.getOrDefault(word, 0)+1);
                if ( maxCount < map.get(word)){
                    maxCount = map.get(word);
                    res = word;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String paragraph = "Bob";
        String banned[] = new String[0];
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }
}
