package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

     DisjointSet(int n){
        for ( int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findUltimateParent(int node){
         if ( node == parent.get(node)) return node;
         else {
             int uParent = findUltimateParent(parent.get(node));
             parent.set(node, uParent);
             return parent.get(node);
         }
    }

    public void unionByRank(int u, int v){
         int ultimateParentU = findUltimateParent(u);
         int ultimateParentV = findUltimateParent(v);
         if ( ultimateParentU == ultimateParentV) return;

         if ( rank.get(ultimateParentU) > rank.get(ultimateParentV)){
             parent.set(ultimateParentV, ultimateParentU);
         } else if ( rank.get(ultimateParentU) < rank.get(ultimateParentV)){
             parent.set(ultimateParentU, ultimateParentV);
         } else {
             parent.set(ultimateParentV, ultimateParentU);
             int uRank = rank.get(ultimateParentU);
             rank.set(ultimateParentU, uRank+1);
         }
    }

    public void unionBySize(int u, int v){
         int ultimateParentU = findUltimateParent(u);
         int ultimateParentV = findUltimateParent(v);
         if (ultimateParentU == ultimateParentV) return;
         if ( size.get(ultimateParentU) < size.get(ultimateParentV)){
             parent.set(ultimateParentU, ultimateParentV);
             size.set(ultimateParentV, size.get(ultimateParentU)+ size.get(ultimateParentV));
         } else {
             parent.set(ultimateParentV, ultimateParentU);
             size.set(ultimateParentU, size.get(ultimateParentU)+ size.get(ultimateParentV));
         }
    }
}
