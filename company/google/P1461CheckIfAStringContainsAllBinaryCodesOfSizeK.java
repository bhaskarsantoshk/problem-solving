package company.google;

public class P1461CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodesBruteForce(String s, int k) {
        for ( int i=0; i<=(int)(Math.pow(2,k)-1); i++){
            String str = Integer.toBinaryString(i);
            if ( str.length() < k){
                str = "0".repeat(k-str.length())+ str;
            }
            System.out.println(str);
            if (!s.contains(str)) return false;
        }
        return true;
    }

    public boolean hasAllCodes(String s, int k) {
        int req = ( 1 << k);
        boolean[] seen = new boolean[req];
        int mask = req-1;
        int hash = 0;
        for ( int i=0; i<s.length(); i++){
           hash = ((hash << 1) & mask) | (s.charAt(i) & 1);
           if ( i >= k-1 && !seen[hash]){
               seen[hash] = true;
               req--;
               if ( req == 0) return true;
           }
        }
        return false;
    }

    public static void main(String[] args){
        String s = "00000000010011101";
        int k = 4;
        P1461CheckIfAStringContainsAllBinaryCodesOfSizeK obj = new P1461CheckIfAStringContainsAllBinaryCodesOfSizeK();
        System.out.println(obj.hasAllCodes(s,k));
    }
}
