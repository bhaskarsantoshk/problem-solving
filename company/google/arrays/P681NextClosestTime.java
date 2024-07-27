package company.google.arrays;

import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

class P681NextClosestTime {
    public String nextClosestTime(String time) {
        // Convert current time to minutes
        int curTimeInMinutes = Integer.parseInt(time.substring(0, 2)) * 60;
        curTimeInMinutes += Integer.parseInt(time.substring(3));

        // Create a set of allowed digits
        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c == ':') continue;
            allowed.add(c - '0');
        }

        // Loop to find the next closest time
        while (true) {
            curTimeInMinutes = (curTimeInMinutes + 1) % (24 * 60);
            int[] digits = new int[] {
                    curTimeInMinutes / 60 / 10,
                    curTimeInMinutes / 60 % 10,
                    curTimeInMinutes % 60 / 10,
                    curTimeInMinutes % 60 % 10
            };

            boolean isValid = true;
            for (int d : digits) {
                if (!allowed.contains(d)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return String.format("%02d:%02d", curTimeInMinutes / 60, curTimeInMinutes % 60);
            }
        }
    }
}
