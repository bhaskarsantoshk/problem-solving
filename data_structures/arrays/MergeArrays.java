package data_structures.arrays;

public class MergeArrays {
    public static int[] merge(int[] a, int[] b){
        int res[] = new int[a.length+b.length];
        int index = 0;
        int i=0,j=0;
        while ( i < a.length && j < b.length){
            if (a[i] < b[j]){
                res[index] = a[i++];
            }
            else{
                res[index] = b[j++];
            }
            index++;
        }
        while ( i < a.length){
            res[index++] = a[i++];
        }
        while ( j < b.length){
            res[index++] = b[j++];
        }
        return res;
    }
}
