package OnlineAssessments;

public class FreshPromotion {
    public static int freshPromotion(String[] shoppingCart, String[][] codeList){
        int cartIdx = 0;
        int codeIdx = 0;

        while ( cartIdx < shoppingCart.length && codeIdx < codeList.length ) {
            if ( (shoppingCart[cartIdx].equals(codeList[codeIdx][0]) || codeList[codeIdx][0].equals("anything") )
                && (hasOrder(cartIdx, shoppingCart, codeList[codeIdx])) ) {
                cartIdx += codeList[codeIdx++].length;
            } else {
                cartIdx++;
            }
        }
        return codeIdx == codeList.length ? 1: 0;
    }

    private static boolean hasOrder(int cartIdx, String[] shoppingCart, String[] order) {
        for (String code: order){
            if ( cartIdx < shoppingCart.length && code.equals(shoppingCart[cartIdx]) || code.equals("anything")) {
                cartIdx++;
            } else {
                return false;
            }
        }
        return true;
    }

}
