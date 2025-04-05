package codingNinjas;

import java.util.ArrayList;

public class ReverseTheArray {
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        reverse(arr, m+1, arr.size()-1);
    }

    private static void reverse(ArrayList<Integer> arr, int left, int right){
        while ( left < right ){
            int temp = arr.get(left);
            arr.set(left++, arr.get(right));
            arr.set(right--, temp);
        }
    }
}

// https://www.naukri.com/code360/problems/reverse-the-array_1262298?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
