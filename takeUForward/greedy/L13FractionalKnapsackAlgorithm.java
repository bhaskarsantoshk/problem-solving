package takeUForward.greedy;

import java.util.Arrays;

public class L13FractionalKnapsackAlgorithm {
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, (a,b)-> b.value/b.weight - a.value/a.weight);
        double maxVal = 0;
        for ( int i=0; i<n; i++) {
            if ( w > arr[i].weight) {
                maxVal += arr[i].value;
                w -= arr[i].weight;
            } else {
                maxVal += ((double) arr[i].value /arr[i].weight) * w;
                break;
            }
        }
        return maxVal;
    }

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
