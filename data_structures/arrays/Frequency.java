package data_structures.arrays;

public class Frequency {
    public static int frequency ( int[] a, int key ){
        int lowIndex = getLowIndex(a, key);
        int highIndex = getHighIndex (a, key);
        if ( lowIndex != -1 && highIndex != -1){
            return highIndex-lowIndex+1;
        }
        return -1;
    }

    private static int getHighIndex(int[] a, int key) {
        int start = 0, end = a.length-1, result = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( a[mid] == key ){
                result=mid;
                start = mid+1;
            }
            else if(a[mid]< key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return result;
    }

    private static int getLowIndex(int[] a, int key) {
        int start = 0, end = a.length-1, result = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( a[mid] == key ){
                result=mid;
                end = mid-1;
            }
            else if ( a[mid] < key ){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
    }
}
