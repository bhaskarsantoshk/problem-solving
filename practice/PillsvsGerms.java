package practice;

import java.util.Scanner;

public class PillsvsGerms {
    public static void main ( String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while ( t--!= 0){
            int m =in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            char [][] board = new char[m][n];
            int index = 0;
            while ( m--!= 0){
                String s= in.nextLine();
                board[index++] = s.toCharArray();
            }
            //printArray(board, board.length, board[0].length);
            attack(board);
            //printArray(board, board.length, board[0].length);
            System.out.println(countGerms(board));
        }
    }

    private static void printArray(char[][] board, int length, int length1) {
        for ( int i=0; i<length; i++){
            for ( int j=0; j<length1; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int countGerms(char[][] board) {
        int count =0;
        for ( int i=0; i<board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                if ( board[i][j] == 'x'){
                    count++;
                }
            }
        }
        return count;
    }

    private static void attack(char[][] board) {
        for ( int i=0; i< board.length; i++){
            for ( int j=0; j<board[0].length; j++){
                killGerms(board, i , j);
            }
        }
    }

    private static void killGerms(char[][] board, int i, int j) {

        if ( board[i][j] == 'r'){
            int rowNumber[] ={0,0,1,-1,1,1,-1,-1};
            int colNumber[] ={1,-1,0,0,1,-1,1,-1};
            for ( int X=0; X<rowNumber.length; X++){
                if ( inBoundary(i+rowNumber[X], j+colNumber[X], board) && board[i+rowNumber[X]][j+colNumber[X]]=='x'){
                    board[i+rowNumber[X]][j+colNumber[X]] ='0';
                }
            }
        }
        else if ( board[i][j] == 'b'){
            // (0,0) - (0,1), (1,0), (0,-1), (-1,0)
            int rowNumber[] = {0,1,0,-1};
            int colNumber[] ={1,0,-1,0};
            for ( int X=0; X<4; X++){
                //System.out.println((i+rowNumber[X])+" "+ (j+colNumber[X]) +" "+ inBoundary(i+rowNumber[X], j+colNumber[X], board) +" "+ board[i+rowNumber[X]][j+colNumber[X]] );
                if ( inBoundary(i+rowNumber[X], j+colNumber[X], board) && board[i+rowNumber[X]][j+colNumber[X]]=='x'){
                        board[i+rowNumber[X]][j+colNumber[X]] ='0';
                }
            }
        }
    }

    private static boolean inBoundary(int i, int j, char[][] board) {
        if ( i < 0 || i >= board.length || j< 0 || j>= board[0].length){
            return false;
        }
        return true;
    }
}
