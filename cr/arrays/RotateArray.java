package cr.arrays;

import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args){
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Array Before Rotation\n"+v1);
        rotate_array_in_place(v1, 2);
        System.out.println("Array After Rotation\n"+v1);
    }
    private static void rotate_array_in_place(List<Integer> arr, int n) {
        int len = arr.size();
        n = n% len;
        if(n<0){
            n = n+len;
        }
        reverse_array(arr, 0, len-1);
        reverse_array(arr, 0, n-1);
        reverse_array(arr, n, len-1);
    }
    private static void reverse_array(List<Integer> arr, int start, int end) {
        while(start < end){
                int temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                ++start;
                --end;
            }
        }
    }

