package data_structures.arrays;

public class RemoveElement {
    public static int[] removeEven(int[] a){
        int index = 0;
        for (int i=0; i<a.length; i++){
            if (a[i] %2 !=0){
                a[index++]=a[i];
            }
        }
        int res[] = new int[index];
        for ( int i=0; i<index; i++){
            res[i] = a[i];
        }
        return res;
    }
}
