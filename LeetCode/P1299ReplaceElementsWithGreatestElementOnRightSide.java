package LeetCode;

public class P1299ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        int index = arr.length-2;
        arr[arr.length-1] = -1;
        while (index >= 0){
            int temp = arr[index];
            arr[index] = max;
            max = Math.max(temp, max);
            index--;
        }
        return arr;
    }
}
