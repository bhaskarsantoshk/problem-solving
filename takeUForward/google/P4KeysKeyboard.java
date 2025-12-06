package takeUForward.google;

import java.util.HashMap;
import java.util.Map;

public class P4KeysKeyboard {
    public int maxA(int n) {
        return helper(n, 0, 0);
    }

    private int helper(int n, int screen, int buffer) {
        if ( n <= 0) return screen;
        int pressA = helper(n-1, screen+1, buffer);
        int pressCTRLv = helper(n-1, screen+buffer, buffer);

        int pressCtrlACtrlC = 0;
        if ( n >= 2){
            pressCtrlACtrlC = helper(n-2, screen, screen);
        }
        return Math.max(Math.max(pressA, pressCTRLv), pressCtrlACtrlC);
    }


    public int maxAMemoized(int n) {
         Map<String, Integer> memo = new HashMap<>();
        return helper(n, 0, 0, memo);
    }

    private int helper(int n, int screen, int buffer, Map<String, Integer> memo) {
        if (n <= 0) return screen;

        String key = n + "|" + screen + "|" + buffer;
        if (memo.containsKey(key)) return memo.get(key);

        int pressA = helper(n - 1, screen + 1, buffer);
        int pressCTRLv = helper(n - 1, screen + buffer, buffer);

        int pressCtrlACtrlC = 0;
        if (n >= 2) {
            pressCtrlACtrlC = helper(n - 2, screen, screen);
        }

        int result = Math.max(Math.max(pressA, pressCTRLv), pressCtrlACtrlC);
        memo.put(key, result);
        return result;
    }
}
