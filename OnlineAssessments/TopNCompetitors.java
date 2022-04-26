package OnlineAssessments;

import java.util.*;

public class TopNCompetitors {
    public static List<String> topNumCompetitors(int numCompetitors,
                                          int topNCompetitors,
                                          List<String> competitors,
                                          int numReviews, List<String> reviews) {
        // Your code here
        Set<String> competitorSet = new HashSet<>(competitors);
        Map<String, Integer> competitorFreq = new HashMap<>();
        for ( String review: reviews){
            Set<String> taken = new HashSet<>();
            String words[] = review.toLowerCase().split("\\W");
            for ( String word: words){
                word = word.toLowerCase();
                if ( competitorSet.contains(word) && !taken.contains(word) ){
                    competitorFreq.put(word, competitorFreq.getOrDefault(word, 0)+1);
                    taken.add(word);
                }
            }
        }

        Queue<String> minHeap = new PriorityQueue<String>(topNCompetitors,
                (competitor1, competitor2) ->
                        (competitorFreq.get(competitor1) == competitorFreq.get(competitor2)) ?
                                competitor2.compareTo(competitor1) :
                                competitorFreq.get(competitor1) - competitorFreq.get(competitor2));

        for ( String competitor: competitorFreq.keySet()){
            minHeap.add(competitor);
            if ( minHeap.size() > topNCompetitors ){
                minHeap.poll();
            }
        }
        List<String> result = new ArrayList<>(minHeap);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> reviews = new ArrayList(
                Arrays.asList("newshop is providing good services in the city; everyone should use newshop",
                        "best services by newshop", "fashionbeats has great services in the city",
                        "I am proud to have fashionbeats", "mymarket has awesome services",
                        "Thanks Newshop for the quick delivery"));

        List<String> competitors = new ArrayList<String>(
                Arrays.asList("newshop", "shopnow", "afashion", "fashionbeats", "mymarket", "tcellular"));

        System.out.println(topNumCompetitors(6, 2, competitors, 6, reviews));
    }
}
