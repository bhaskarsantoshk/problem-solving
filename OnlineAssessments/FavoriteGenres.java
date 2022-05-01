package OnlineAssessments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
    public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        // Song - Genre Map
        Map<String, String> songGenreMap = new HashMap<>();
        for ( String genre: genreMap.keySet()){
            for (String song: genreMap.get(genre)){
                songGenreMap.put(song, genre);
            }
        }
        // User - Favorite Genre
        Map<String, List<String>> result = new HashMap<>();
        for ( String user: userMap.keySet()){
            int max = 0;
            Map<String, Integer> genreCount = new HashMap<>();
            for ( String song: userMap.get(user)){
                String genre = songGenreMap.get(song);
                if ( genre != null ) {
                    int c = genreCount.getOrDefault(genre, 0) + 1;
                    genreCount.put(genre, c);
                    max = Math.max(max, c);
                }
            }

            for ( String genre : genreCount.keySet()){
                if ( genreCount.get(genre) == max){
                    result.get(user).add(genre);
                }
            }
        }
        return result;
    }


}
