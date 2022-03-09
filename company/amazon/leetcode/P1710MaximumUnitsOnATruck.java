package company.amazon.leetcode;

import java.util.Arrays;

public class P1710MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->Integer.compare(b[1], a[1]));
        int units = 0;
        for ( int[] box : boxTypes ){
            if ( truckSize >= box[0]){
                units += box[0] * box[1];
                truckSize -= box[0];
            } else {
                units += truckSize * box[1];
                return units;
            }
        }
        return units;
    }

    /**
     * Source: https://leetcode.com/problems/maximum-units-on-a-truck/discuss/999125/JavaPython-3-Sort-by-the-units-then-apply-greedy-algorithm.
     * Why greedy algorithm works with this problem and why we don't need to use knapsack dp? how do we know when a problem is knapsack or when it is greedy?
     *
     * A2: In this problem, it says "You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize." That means we do NOT need to treat the boxes of same box type as inseparable. E.g., if necessary to get optimal solution, we can choose 1, 2, ..., or i boxes from a certain type, when we put boxes onto the truck. Therefore, we should put the type of boxes with the most units in order to achieve maximum units.
     *
     * If the problem changes the rule to "If you choose a box type, you must choose all of the boxes of this type", it is same as the Knapsack problem and we have to use DP to solve it.
     *
     * In Knapsack problem, different items have different weights and there is a total weight limit, and we can NOT break items into
     * pieces to get optimal solution. Therefore, there is no way to apply greedy algorithm. Of couse, if we are allowed to break the items into arbitrary units of weight, it is same as this truck problem and we can apply greedy algorithm.
     *
     * Strictly speaking, when using greedy algorithm to solve a problem, we need to justity its correctness by proving its: 1) Greedy choice property and 2)optimal substructure property. You can refer my proof in 881. Boats to Save People for reference.
     *
     * Typically, Knapsack problem often arises in resource allocation where the decision makers have to choose from a set of non-divisible objects, projects or tasks under a fixed budget or time constraint, respectively.
     */
}
