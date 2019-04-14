package microsoft;

import java.util.Arrays;
import java.util.Scanner;

public class WinOrLose {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while(t--!=0){
            int n = in.nextInt();
            int a[]= new int[n];
            int b[]= new int[n];
            for(int i=0;i<n;i++){
                a[i]= in.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i]= in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);
            boolean flag = true;
            for(int i=0;i<n;i++){
                if(a[i]>b[i]){
                    flag= false;
                    break;
                }
            }

            if(flag== true){
                System.out.println("WIN");
            }
            else{
                System.out.println("LOSE");
            }
        }

    }
}
