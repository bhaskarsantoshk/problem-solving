package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix1 {
    public static void main(String[] args){
        int a[][] = new int[4][4];
        int x=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4; j++){
                a[i][j]=x;
                x++;
            }
        }

        List<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0;i<4;i++){
            A.add(new ArrayList<Integer>());
            for(int j=0;j<4;j++){
                A.get(i).add(a[i][j]);
            }
        }
        System.out.println(A);
        System.out.println(spiralOrder(A));
    }

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int top=0, bottom= A.size()-1, left =0, right = A.get(0).size()-1;
        int dir =0;
        while(top<=bottom && left <= right){
            if(dir==0){
                for(int i=left; i<=right;i++){
                    result.add(A.get(top).get(i));
                }
                dir=1;
                top++;
            }
            else if(dir ==1){
                for(int i=top;i<=bottom;i++){
                    result.add(A.get(i).get(right));
                }
                right--;
                dir=2;
            }
            else if(dir == 2){
                for(int i= right; i>=left; i--){
                    result.add(A.get(bottom).get(i));
                }
                dir=3;
                bottom--;
            }
            else if(dir == 3){
                for(int i=bottom; i>=top; i--){
                    result.add(A.get(i).get(left));
                }
                dir =0;
                left++;
            }
        }

        return result;
    }
}

// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
