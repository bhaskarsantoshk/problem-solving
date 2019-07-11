package interviewbit.arrays;

import java.util.ArrayList;

import static standard_algorithms.Sorting.printArray;

public class MAXSPPROD {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int leftSpecial[] = new int[A.size()];
        leftSpecial[0] = 0;
        int max = 0;
        for (int i= 1; i < A.size(); i++){
            max = Math.max ( leftSpecial[i-1], A.get(i-1) );
            leftSpecial[i] = max;
            if ( leftSpecial[i]  <  A.get(i)){
                leftSpecial[i] =0;
            }
        }

        int rightSpecial[] = new int[A.size()];
        rightSpecial[A.size()-1] = 0;
        int min = 0;
        for (int i= A.size()-2; i>=0; i--){
            min = Math.min ( leftSpecial[i+1], A.get(i+1));
            rightSpecial[i] = min;
            if ( rightSpecial[i] < A.get(i)){
                rightSpecial[i] =0;
            }
        }
        printArray(leftSpecial);
        System.out.println();
        printArray(rightSpecial);
        System.out.println();
        int prod=1;
        int maxProd = Integer.MIN_VALUE;
        int c = 1000000007;
        for ( int i=0; i<leftSpecial.length; i++){
            prod= ((leftSpecial[i] % c) * (rightSpecial[i] % c))%c;
            maxProd = Math.max(prod, maxProd);
        }

        return maxProd;
    }

    public static void main(String[] args ){
        int a[] = { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9};
        ArrayList<Integer> A = new ArrayList<>();
        for ( int x: a){
            A.add(x);
        }
        MAXSPPROD obj = new MAXSPPROD();

        System.out.println(obj.maxSpecialProduct(A));

    }
}
