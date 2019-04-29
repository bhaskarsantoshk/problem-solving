package LeetCode;

public class P977SquaresofaSortedArray {
    public int[] sortedSquares(int[] a) {
        int start = 0, end = a.length-1;
        int result[] = new int[a.length];
        int index = a.length-1;
        while(start<=end){
            if(Math.abs(a[start]) > Math.abs(a[end])){
                result[index] = a[start] * a[start];
                start++;
            }
            else{
                result[index] = a[end] * a[end];
                end--;
            }
            index--;
        }
        return result;
    }
}

