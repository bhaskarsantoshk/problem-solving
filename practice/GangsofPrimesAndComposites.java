package practice;

import java.util.Arrays;
import java.util.Scanner;

public class GangsofPrimesAndComposites {
    private static boolean[] primeSet = new boolean[10001];
    public static void main(String[] args){
        generatePrimeSet( primeSet , primeSet.length);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while ( t!= 0){
            int m= in.nextInt();
            int n= in.nextInt();
            int dataSet[][] = new int[m][n];

            for ( int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    dataSet[i][j] = in.nextInt();
                }
            }
            int[][] dataSet1= createCopy(dataSet);
            int[][] dataSet2 = createCopy(dataSet);
            //System.out.println(connectedComponentsPrime(dataSet1));
            System.out.println(connectedComponentsPrime(dataSet1)+" "+connectedComponentsComposite(dataSet2));
        }
    }

    private static int connectedComponentsComposite(int[][] dataSet1) {
        boolean [][] visited = new boolean[dataSet1.length][dataSet1[0].length];
        int connectedCompoenentsComposite = 0;
        for ( int i=0; i< dataSet1.length; i++){
            for ( int j=0; j<dataSet1[0].length; j++){
                if ( isComposite(dataSet1[i][j]) && !visited[i][j]){
                    dfsComposite(dataSet1, i, j, dataSet1.length, dataSet1[0].length, visited);
                    ++connectedCompoenentsComposite;
                }
            }
        }
        return connectedCompoenentsComposite;
    }

    private static int connectedComponentsPrime(int[][] dataSet1) {
        boolean [][] visited = new boolean[dataSet1.length][dataSet1[0].length];
        int connectedCompoenentsPrime = 0;
        for ( int i=0; i< dataSet1.length; i++){
            for ( int j=0; j<dataSet1[0].length; j++){
                if ( isPrime(dataSet1[i][j]) && !visited[i][j]){
                    dfs(dataSet1, i, j, dataSet1.length, dataSet1[0].length, visited);
                    ++connectedCompoenentsPrime;
                }
            }
        }
        return connectedCompoenentsPrime;
    }

    private static void dfsComposite(int[][] dataSet1, int row, int col, int rowLength, int colLength, boolean[][] visited) {
        int rowNbr[] = {-1, 1, 0, 0};
        int colNbr[] = {0, 0, 1, -1};
        visited[row][col] = true;
        for (int k = 0; k < 4; ++k) {
            if (isPartOfCompositeGang(dataSet1, row + rowNbr[k], col + colNbr[k], rowLength, colLength, visited)) {
                dfsComposite(dataSet1, row + rowNbr[k], col + colNbr[k], rowLength, colLength, visited);
            }
        }

    }

    private static void dfs(int[][] dataSet1, int row, int col, int rowLength, int colLength, boolean[][] visited) {
        int rowNbr[] = {-1, 1, 0, 0};
        int colNbr[] = {0, 0, 1, -1};
        visited[row][col] = true;
        for (int k = 0; k < 4; ++k) {
            if (isPartOfPrimeGang(dataSet1, row + rowNbr[k], col + colNbr[k], rowLength, colLength, visited)) {
                dfs(dataSet1, row + rowNbr[k], col + colNbr[k], rowLength, colLength, visited);
            }
        }

    }

    private static boolean isPartOfPrimeGang(int[][] dataSet1, int row, int col, int rowLength, int colLength, boolean[][] visited) {
        return (row >= 0) && (row < rowLength) && (col >= 0) && (col < colLength) && (isPrime(dataSet1[row][col]) && !visited[row][col]);
    }

    private static boolean isPartOfCompositeGang(int[][] dataSet1, int row, int col, int rowLength, int colLength, boolean[][] visited) {
        return (row >= 0) && (row < rowLength) && (col >= 0) && (col < colLength) && (isComposite(dataSet1[row][col]) && !visited[row][col]);
    }

    private static int[][] createCopy(int[][] dataSet) {
        int[][] dataSetClone = new int[dataSet.length][dataSet[0].length];
        for ( int i=0; i<dataSet.length; i++){
            for ( int j=0; j<dataSet[0].length; j++){
                dataSetClone[i][j] = dataSet[i][j];
            }
        }
        return dataSetClone;
    }

    private static void generatePrimeSet(boolean[] primeSet, int length) {
        Arrays.fill(primeSet, true);
        primeSet[0]= primeSet[1] = false;
        for ( int p=2; p<= 10000/p; p++){
            if ( primeSet[p] == true){
                for ( int i= p*p; i<= 10000; i+=p ){
                    primeSet[i] = false;
                }
            }
        }
    }

    private static boolean isPrime(int x){
        return primeSet[x];
    }
    private static boolean isComposite( int x){
        return !primeSet[x];
    }
}
