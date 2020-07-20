package bytebybyte;
import java.util.Arrays;

public class MakingChange {

    public static int change(int x, int[] coins ){
        int []cache = new int[x];
        Arrays.fill(cache, -1 );
        return change(x, coins, cache);
    }
    public static int change ( int x, int [] coins, int [] cache ){
        if ( x == 0 ) return 0;
        int min = x;
        for ( int coin : coins ){
            if ( x - coin >= 0 ){
                int c;
                if ( cache[x-coin] >= 0 ){
                    c = cache[x-coin];
                }
                else {
                    c = change(x - coin, coins);
                }
                if (min > c + 1 ){
                    min = c +  1;
                }
            }
        }
        return min;
    }

    public static void main( String[] args ){
        int coins[] ={ 1,5, 10, 25};
        System.out.println(change(32, coins));
    }
}
