package takeUForward.greedy.revision;

public class P2LemonadeChange {
    public static boolean lemonadeChange(int []bills) {
        int five =0, ten=0;
        for ( int bill: bills){
            if ( bill == 5) five++;
            else if ( bill == 10){
                if ( five < 1) return false;
                five--;
                ten++;
            } else {
                if ( five >0 && ten>0){
                    ten--;
                    five--;
                } else if ( five >= 3) {
                    five-=3;
                } else return false;
            }
        }
        return true;
    }
}
