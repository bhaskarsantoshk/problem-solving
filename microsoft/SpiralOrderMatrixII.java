package microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixII {
    public static void main(String[] args){
        System.out.println(generateMatrix(3));
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int x=1;
        for(int i=0;i<A; i++){
            result.add(new ArrayList<Integer>());
            for(int j=0;j<A; j++) {
                result.get(i).add(0);

            }
        }


        int top=0, bottom= A-1, left =0, right = A-1;
        int dir =0;
         x=1;
        while(top<=bottom && left <= right){
            if(dir==0){
                for(int i=left; i<=right;i++){
                    result.get(top).set(i, x);
                    x++;
                }
                dir=1;
                top++;
            }
            else if(dir ==1){
                for(int i=top;i<=bottom;i++){
                    result.get(i).set(right, x);
                    x++;
                }
                right--;
                dir=2;
            }
            else if(dir == 2){
                for(int i= right; i>=left; i--){
                    result.get(bottom).set(i, x);
                    x++;
                }
                dir=3;
                bottom--;
            }
            else if(dir == 3){
                for(int i=bottom; i>=top; i--){
                    result.get(i).set(left, x);
                    x++;
                }
                dir =0;
                left++;
            }
        }
        return result;

    }
}
