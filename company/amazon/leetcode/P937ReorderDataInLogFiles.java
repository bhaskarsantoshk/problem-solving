package company.amazon.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P937ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');

                int s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                int s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
                if ( s1FirstCharacter <= '9' ){
                    if ( s2FirstCharacter <= '9') return 0;
                    else return 1;
                }
                if ( s2FirstCharacter <= '9') return -1;

                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if ( preCompute == 0 ) {
                    return s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));
                }
                return preCompute;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
