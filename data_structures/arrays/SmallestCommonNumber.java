package data_structures.arrays;

public class SmallestCommonNumber {
    public static int smallestAmong3 (int a[], int[]b, int[] c){
        int i=0,j=0,k=0;
        while ( i <a.length && j<b.length && k <c.length){
            if (a[i] == b[j] && b[j] == c[k]){
                return a[i];
            }
            if ( a[i] <= b[j] && a[i] <= c[k]){
                i++;
            }
            else if (b[j] <= a[i] && b[j] <= c[k]){
                j++;
            }
            else if ( c[k] <= a[i] && c[k] <= b[j]){
                k++;
            }
        }
        return -1;
    }
}
