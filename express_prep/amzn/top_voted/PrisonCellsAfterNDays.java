package express_prep.amzn.top_voted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int cycle = 0;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int remaining = 0;
        while ( i < n){
            String key = Arrays.toString(cells);
            if ( map.containsKey(key)){
                cycle = i - map.get(key);
                remaining = (n-i) % cycle;
                break;
            }
            map.put(key, i);
            cells = getNext(cells);
            i++;
        }
        while ( remaining != 0){
            cells = getNext(cells);
            remaining--;
        }
        return cells;
    }

    private int[] getNext(int[] cells) {
        int res[] = new int[cells.length];
        for ( int i=1; i<cells.length-1; i++){
            if ( cells[i-1] == cells[i+1]){
                res[i]=1;
            }
        }
        return res;
    }
}
