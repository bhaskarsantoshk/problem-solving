package LeetCode;

public class P1482MinimumNumberOfDaysToMakeMBouquets {
  
    public int minDaysBruteForce(int[] bloomDay, int m, int k) {
        if ( bloomDay == null ||
                ( bloomDay.length == 0 && m>0 & k>0 ) || bloomDay.length < m * k ) return -1;

        int minDay = bloomDay[0];
        int maxDay = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }
        for ( int day=minDay; day<=maxDay; day++ ){
            if ( possible(bloomDay, m, k, day) ) return day;
        }
        return -1;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ( bloomDay == null ||
                ( bloomDay.length == 0 && m>0 & k>0 ) || bloomDay.length < m * k ) return -1;

        int minDay = bloomDay[0];
        int maxDay = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }
        int start = minDay, end = maxDay;
        while ( start <= end ){
            int mid = start + (end - start)/2;
            if ( possible(bloomDay, m, k, mid) ){
                end = mid;
            } else {
                start = mid+1;
            }
            if (start == end  && possible(bloomDay, m, k, mid) ) return start;
        }

        return -1;
    }

    // [ 7 7 7 7 13 11 12 7 ] m= 2, k = 3
    // On day 7
    // at index 4: adjacentFlowers = 4 , m += 4/3, m becomes 1
    // at index 7: adjacentFlowers = 1
    private boolean possible(int[] bloomDay, int m, int k, int day) {
        int adjacentFlowers = 0;
        int numOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if ( day >= bloomDay[i]){
                adjacentFlowers++;
            } else {
                    numOfBouquets += (adjacentFlowers/k);
                    adjacentFlowers = 0;
            }
        }
        numOfBouquets += (adjacentFlowers/k);
        if ( numOfBouquets >= m ) return true;
        return false;
    }

    // bloomDay = [1,10,3,10,2], m = 3, k = 1
    // minDay 1 maxDay 10
    // day 1-> numOfBouquets = 1 at index 1
    // day 2-> numOfBouquets = 1 at index 1, numOfBouquets = 1+1 after loop
    // day 3 -> numOfBouquets = 1 at index 1, numOfBouquets = 2 at index 2, numOfBouquets = 3 at index 4

    public static void main(String[] args) {
        int [] bloomDay = {1,10,3,10,2};
        int k = 1;
        int m =3;
        P1482MinimumNumberOfDaysToMakeMBouquets obj = new P1482MinimumNumberOfDaysToMakeMBouquets();
        System.out.println(obj.minDays(bloomDay, m, k));
    }
}
