package company.google.others;

import java.util.Map;
import java.util.TreeMap;

public class P731MyCalendarII {

    TreeMap<Integer, Integer> calendar;

    public P731MyCalendarII() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start,0)+1);
        calendar.put(end, calendar.getOrDefault(end, 0)-1);
        int count =0;
        for (Map.Entry<Integer, Integer> entry: calendar.entrySet()){
            count += entry.getValue();
            if ( count > 2){
                calendar.put(start, calendar.getOrDefault(start,0)-1);
                if ( calendar.get(start) == 0) calendar.remove(start);
                calendar.put(end, calendar.getOrDefault(end, 0)+1);
                if ( calendar.get(end)==0) calendar.remove(end);
                return false;
            }
        }
        return true;
    }
}
