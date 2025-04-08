package takeUForward.greedy.revision;

import java.util.Arrays;
import java.util.Collections;

public class P13FractionalKnapsack {
    static class Pair
    {
        int weight;
        int value;
        Pair(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }

    }


    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (item1, item2)-> Double.compare((double)item2.value/item2.weight,
                (double)item1.value/item1.weight));
        double totalValue = 0;
        for ( int i=0; i<n; i++){
            if ( items[i].weight <= w){
                totalValue += items[i].value;
                w -= items[i].weight;
            } else {
                totalValue += ((double)items[i].value/items[i].weight * w );
                break;
            }
        }
        return totalValue;
    }

}
