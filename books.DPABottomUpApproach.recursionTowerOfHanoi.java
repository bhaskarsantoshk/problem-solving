package books.DPABottomUpApproach.recursion;

public class TowerOfHanoi {

    public static void towerOfHanoi ( char s, char d, char e, int n){
        if ( n <= 0 ) return;
        towerOfHanoi(s,e,d,n-1);
        System.out.println("Move Disk "+n+ " from "+s + " to "+ d);
        towerOfHanoi(e,d,s, n-1);
    }

    public static void main(String[] args){

        towerOfHanoi('S','D','E',2);
    }

}
