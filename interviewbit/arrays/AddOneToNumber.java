package interviewbit.arrays;

import java.util.ArrayList;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        for (int i=A.size()-1; i>= 0; i-- ){
            int sum = carry + A.get(i);
            System.out.println(sum);
            if (sum < 10){
                A.set(i, sum);
                for ( int j=0; j<A.size(); i++){
                    if ( A.get(j) == 0){
                        A.remove(0);
                    }
                    else{
                        break;
                    }
                }
                return A;
            }
            else{
                A.set(i, 0);
                carry = 1;
            }
        }
        if ( carry == 1 ){
            A.add(0, 1);
        }
        return A;
    }

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(0);
        AddOneToNumber obj = new AddOneToNumber();
        System.out.println(obj.plusOne(A));
    }
}
