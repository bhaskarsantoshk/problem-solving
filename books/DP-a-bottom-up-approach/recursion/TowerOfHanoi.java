public class TowerOfHanoi {
  
  public void towerOfHanoi( char s, char d, char e, int n){
      if (n <=0 ) return;
      towerOfHanoi(s,e,d, n-1);
      System.out.printf ("Move Disk %d from %d to %d",n,s,d);
      towerOfHanoi(e,d,s,n-1);
  }

}
