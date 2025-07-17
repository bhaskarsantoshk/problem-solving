package company.karat;

import java.util.*;

public class P1604AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> userTimes = new HashMap<>();
        for ( int i=0; i<keyName.length; i++){
            String name = keyName[i];
            String time = keyTime[i];
            int hour = Integer.parseInt(time.split(":")[0]);
            int minutes = Integer.parseInt(time.split(":")[1]);
            int totalMin = hour * 60 + minutes;

            userTimes.computeIfAbsent(name, k-> new ArrayList<>()).add(totalMin);
        }

        List<String> result = new ArrayList<>();
        for ( String name : userTimes.keySet()){
            List<Integer> times = userTimes.get(name);
            Collections.sort(times);
            for ( int i=2; i<times.size(); i++){
                if ( times.get(i) - times.get(i-2) <= 60) {
                    result.add(name);
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
