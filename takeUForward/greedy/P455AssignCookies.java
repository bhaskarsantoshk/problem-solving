package takeUForward.greedy;

import java.util.Arrays;

public class P455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i =0, j=0;
        while (i < g.length && j <s.length){
            if ( g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return j;
    }
}
