package data_structures.arrays;

public class SquareSort {
    public static int[] squareSort(int [] a){
        int[] squares = new int[a.length];
        int left = 0, right = a.length-1;
        int index = a.length-1;
        while ( left <= right){
            int leftSquare = a[left] * a[left];
            int rightSquare = a[right] * a[right];
            if ( leftSquare > rightSquare){
                squares[index] = leftSquare;
                left++;
            }
            else{
                squares[index] = rightSquare;
                right--;
            }
            index--;
        }
        return squares;
    }
}
