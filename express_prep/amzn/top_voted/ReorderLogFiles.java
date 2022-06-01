package express_prep.amzn.top_voted;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComprator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int spaceIndexS1 = s1.indexOf(" ");
                int spaceIndexS2 = s2.indexOf(" ");

                char s1FirstCharacter = s1.charAt(spaceIndexS1+1);
                char s2FirstCharacter = s2.charAt(spaceIndexS2+1);

                if ( s1FirstCharacter <= '9'){
                    if ( s2FirstCharacter <= '9'){
                        return 0;
                    }
                    else {
                        return 1;
                    }
                }
                if ( s2FirstCharacter <= '9'){
                    return -1;
                }

                int preCompute = s1.substring(spaceIndexS1+1).compareTo(s2.substring(spaceIndexS2+1));
                if ( preCompute == 0){
                    return s1.substring(0, spaceIndexS1).compareTo(s2.substring(0, spaceIndexS2));
                }
                return preCompute;
            }
        };

        Arrays.sort(logs, myComprator);

        return logs;
    }
}
