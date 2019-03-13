package interviewbit.arrays;

import java.util.ArrayList;

public class FindDuplicateinArray {
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(4);
        a.add(1);
        int result = repeatedNumber(a);
        System.out.println(result);
    }

    private static int repeatedNumber(final ArrayList<Integer> a) {
        final int n = a.size() - 1;
        // int[] A = new int[a.size()];
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        for (int e : a) {
            x = x ^ e;
        }
        if (x == 0) return -1;
        else return x;
    }
}
