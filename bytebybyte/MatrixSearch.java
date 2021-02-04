package bytebybyte;

public class MatrixSearch {

    public boolean contains(int [][] arr, int x){
        if ( arr.length == 0 || arr[0].length == 0){
            return false;
        }
        int row = 0, col = arr.length-1;
        while ( row < arr[0].length && col >= 0){
            if ( arr[row][col] == x) return true;
            if ( arr[row][col] < x) row++;
            else col--;
        }
        return false;
    }
}

// Rows and Columns are in sorted order
// what happens when there are repeated element : if the problem is about finding position,
// current case is to return true if element exists

// 1d array: simple binary search works
// approach 1: apply binary search on each array - T = O(M log N)
// approach 2: find the right row , and do binary search on the desired row
// to find the right row, compare the key element with last element of each row - if it's greater than key, it possibly is the desired row
// T = O(M+log N)

// Approach 3: using approach 2, when you see the element is less than key, you can eliminate the row and all rows before it.
// when you see the element is greater than the key, you can eliminate the column and all columns after it
