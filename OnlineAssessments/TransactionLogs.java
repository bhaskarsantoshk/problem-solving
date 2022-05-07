package OnlineAssessments;

import java.util.*;

public class TransactionLogs {

    static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> userImpressions = new HashMap<>();
        for ( String logLine: logs ) {
            String[] log = logLine.split(" ");
            userImpressions.put(log[0], userImpressions.getOrDefault(log[0], 0)+1);
            if ( !log[0].equals(log[1]) ) {
                userImpressions.put(log[1], userImpressions.getOrDefault(log[1], 0)+1);
            }
        }

        List<String> userIds = new ArrayList<>();
        for ( Map.Entry<String, Integer> entry: userImpressions.entrySet()){
            if ( entry.getValue() >= threshold){
                userIds.add(entry.getKey());
            }
        }
        Collections.sort(userIds, (s1,s2)->Integer.parseInt(s1)-Integer.parseInt(s2));
        return userIds;
    }


    public static void main(String[] args) {
        List<String> input = new ArrayList() {{
            add ("345366 89921 45");
            add ("029323 38239 23");
            add ("38239 345366 15");
            add ("029323 38239 77");
            add ("345366 38239 23");
            add ("029323 345366 13");
            add ("38239 38239 23");
        }};

        processLogs(input, 2).forEach(System.out::println);
    }

}
