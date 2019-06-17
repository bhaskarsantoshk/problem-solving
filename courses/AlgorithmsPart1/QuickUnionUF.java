package courses.AlgorithmsPart1;

public class QuickUnionUF {
    private int[] id;
    public QuickUnionUF(int N){
        id = new int[N];
        for(int i=0; i< N; i++){
            id[i] = i;
        }
    }
    public boolean isConnected (int p, int q){
        return root(p) == root(q);
    }

    private int root(int i){
        while ( i != id[i] ){
            i = id[i];
        }
        return i;
    }

    //Make root of the first item and make it as child of root of the second item
    public void union (int p, int q){
        int i = root(p);
        int j = root(q);
        id [i] = j;
    }
}
