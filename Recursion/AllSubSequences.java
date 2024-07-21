package Recursion;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static standard_algorithms.Sorting.printArray;

public class AllSubSequences {
    public void printAllSubSequences( int[] arr){
        printAllSubSequences(new ArrayList<Integer>(), arr, 0, arr.length);
    }

    private void printAllSubSequences(ArrayList<Integer> list, int[] arr, int index, int length) {
        if ( index >= length ){
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        printAllSubSequences(list, arr, index+1, length);
        list.removeLast();
        printAllSubSequences(list, arr, index+1, length);
    }

    public static void main(String[] args){
        int [] arr = { 3, 1, 2};
        AllSubSequences obj = new AllSubSequences();
        obj.printAllSubSequences(arr);
    }

}
