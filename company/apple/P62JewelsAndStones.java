package company.apple;

public class P62JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int []a = new int[128];
        for ( char c : jewels.toCharArray()){
            a[c]++;
        }
        int count =0;
        for ( char c: stones.toCharArray()){
            if ( a[c] != 0) count++;
        }
        return count;
    }
}
