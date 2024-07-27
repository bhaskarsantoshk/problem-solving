package striver_sde_sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Update the frequency of the current character
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Check if there's a duplicate character
            while (map.get(c) > 1) {
                char leftChar = s.charAt(left);
                // Reduce the frequency of the character at the left pointer
                map.put(leftChar, map.get(leftChar) - 1);
                // Move the left pointer to shrink the window until the substring is valid
                left++;
            }

            // Update the maximum length of the substring without repeating characters
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
