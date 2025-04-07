package takeUForward.greedy.revision;

import java.util.Arrays;

public class P1AssignCookies {
    public static int assignCookie(int []greed, int []size) {
        Arrays.sort(greed);
        Arrays.sort(size);
        int count = 0;
        int greedIndex = 0, cookieIndex=0;
        while ( greedIndex < greed.length && cookieIndex < size.length){
            if ( size[cookieIndex] >= greed[greedIndex]){
                cookieIndex++;
                greedIndex++;
                count++;
            } else {
                cookieIndex++;
            }
        }
        return count;
    }
}
