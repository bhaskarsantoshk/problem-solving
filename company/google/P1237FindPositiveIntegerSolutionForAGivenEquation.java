package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class P1237FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= 1000; ++x) { // upper limit is 1000
            int low = 1, high = 1001;
            while (low < high) {
                int mid = (low + high) / 2;
                if (customfunction.f(x, mid) < z) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (customfunction.f(x, low) == z)
                result.add(Arrays.asList(x, low));

        }
        return result;
    }

    interface CustomFunction {

        public int f(int x, int mid) ;
    }


}
