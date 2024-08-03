package company.google.design;

import java.util.HashMap;
import java.util.Map;

public class P359LoggerRateLimiter {
    Map<String, Integer> log;
    public P359LoggerRateLimiter() {
        log = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if ( log.containsKey(message)){
            int timeDiff = timestamp- log.get(message);
            if ( timeDiff < 10) return false;
        } else {
            log.put(message, timestamp);
        }
        return true;
    }
}
