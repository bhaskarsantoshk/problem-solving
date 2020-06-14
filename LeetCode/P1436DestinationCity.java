package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1436DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for ( List<String> path : paths ){
            map.put(path.get(0), path.get(1));
        }
        String destination = paths.get(0).get(0);
        while ( map.containsKey(destination)){
            destination = map.get(destination);
        }
        return destination;
    }
}
