import java.io.*;
import java.util.*;

public class CountTriangles {

    public static void main(String[] args) {
        FastReader in=new FastReader();
		
		int t=in.nextInt();
		
		for(int i=0;i<t;i++){
			int n=in.nextInt();
			int[] a=new int[n];
			
			
			for(int j=0;j<n;j++){
				a[j]=in.nextInt();
			}
			
			Arrays.sort(a);
			System.out.println(countOfTriangles(a,n));
			
			
			
		}
	}
	
	
	private static int countOfTriangles(int[] arr, int n) {
        int count = 0; 
        for (int i = 0; i < n - 2; ++i) { 
            int k = i + 2; 
            for (int j = i + 1; j < n; ++j) { 
                while (k < n && arr[i] + arr[j] > arr[k]) 
                    ++k;
                if (k > j) 
                    count += k - j - 1; 
            } 
        } 
        return count;  
	}


	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }


}

}
