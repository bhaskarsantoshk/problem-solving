package interviewbit.arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a= new ArrayList<>();
        a.add(new ArrayList<Integer>());
        a.add(new ArrayList<Integer>());
        a.get(0).add(1);
        a.get(0).add(2);
        a.get(1).add(3);
        a.get(1).add(4);
        transpose(a);
        reverseRows(a);
        System.out.println(a);
    }
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private static void transpose(ArrayList<ArrayList<Integer>> a) {
        for(int i=0 ; i<a.size() ; i++){
            for(int j=i; j<a.get(0).size(); j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    private static void reverseRows(ArrayList<ArrayList<Integer>> a) {
            for(int i=0;i<a.size();i++){
                reverseArray(a.get(i));
            }
    }

    private static void reverseArray(ArrayList<Integer> A) {
        for(int i=0;i<A.size()/2;i++){
            int temp = A.get(i);
            A.set(i, A.get(A.size()-1-i));
            A.set(A.size()-i-1, temp);
        }
    }
}

/*
[
    [1, 2],
    [3, 4]
]

 1 2
 3 4

 1 3
 2 4

 3 1
 4 2

[
    [3, 1],
    [4, 2]
]
 */
