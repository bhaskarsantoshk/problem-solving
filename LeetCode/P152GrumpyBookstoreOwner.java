package LeetCode;

public class P152GrumpyBookstoreOwner {
    public int maxSatisfiedBruteForce(int[] customers, int[] grumpy, int minutes) {
        int maxCustomers = 0;

        for ( int i=0; i<=customers.length-minutes; i++ ) {
            int numOfCustomers = getTotalcustomersIfOwnerUsesItoN(customers, grumpy, minutes, i);
            maxCustomers = Math.max(maxCustomers, numOfCustomers);
        }
        return maxCustomers;
    }

    private int getTotalcustomersIfOwnerUsesItoN(int[] customers, int[] grumpy, int minutes, int index) {
        int totalCustomers = 0;
        for ( int i=0; i<customers.length; i++ ) {
            if ( i>=index && i < index+minutes){
                totalCustomers += customers[i];
            } else {
              if ( grumpy[i] == 0 ) {
                  totalCustomers += customers[i];
              }
            }
        }
        return totalCustomers;
    }

    // Optimized 1

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxCustomers = 0;

        int totalCustomers = 0;
        for ( int i=0; i<customers.length; i++ ) {
            if( grumpy[i] == 0 ) {
                totalCustomers += customers[i];
            }
        }

        for ( int i=0; i<=customers.length-minutes; i++ ) {
            int numOfCustomers = getTotalcustomersIfOwnerUsesItoNOptimized(customers, grumpy, minutes, i, totalCustomers);
            maxCustomers = Math.max(maxCustomers, numOfCustomers);
        }
        return maxCustomers;
    }

    private int getTotalcustomersIfOwnerUsesItoNOptimized(int[] customers, int[] grumpy, int minutes, int index, int totalCustomers) {
        for ( int i=index; i<index+minutes; i++ ) {
            if ( grumpy[i] == 1 ) {
                totalCustomers += customers[i];
            }
        }
        return totalCustomers;
    }
}
