package LeetCode;

public class P1351CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int rowIndex = rows-1, colIndex = 0;
        int res = 0;
        while (rowIndex>=0 && colIndex <cols){
            if (grid[rowIndex][colIndex] < 0){
                res += cols - colIndex;
                rowIndex--;
            }
            else{
                colIndex++;
            }
        }
        return res;
    }
}
