package company.google.dynamic_programming;

import java.util.ArrayList;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if ( arr.size() < m) return -1; // number of students more than number of books
        int maxArrayElement = 0, sum = 0;
        for ( int num: arr){
            maxArrayElement = Math.max( maxArrayElement, num);
            sum += num;
        }
        int start = maxArrayElement, end =  sum;
        for ( int pages = start; pages<end; pages++){
            if ( m == allocatedStudents(arr, pages)) return pages;
        }
        return -1;
    }

    private static int allocatedStudents(ArrayList<Integer> arr, int maxPages) {
        int countStudents = 1, pagesToStudent = 0;
        for ( int i=0; i<arr.size(); i++){
            if ( pagesToStudent + arr.get(i) <= maxPages){
                pagesToStudent += arr.get(i);
            } else {
                countStudents++;
                pagesToStudent = arr.get(i);
            }
        }
        return countStudents;
    }
}
