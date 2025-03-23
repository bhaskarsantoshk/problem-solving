package company.microsoft;

public class P3477FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for ( int i=0; i<fruits.length; i++){
            boolean placed = false;
            for ( int j=0; j<baskets.length; j++){
                if ( fruits[i] <= baskets[j]){
                    baskets[j] = -1;
                    placed = true;
                    break;
                }
            }
            if ( !placed ) count++;
        }
        return count;
    }
}
