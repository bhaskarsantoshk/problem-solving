package takeUForward.graph.revision3;

import java.util.*;

public class P41AccountsMerge {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mailMap = new HashMap<>();
        for ( int i=0; i<n; i++){
            for ( int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if ( !mailMap.containsKey(mail)) mailMap.put(mail, i);
                else{
                    ds.union(i, mailMap.get(mail) );
                }
            }
        }

        List<String>[] mergedMail = new ArrayList[n];
        for ( int i=0; i<n; i++) mergedMail[i] = new ArrayList<>();

        for ( Map.Entry<String, Integer> entry : mailMap.entrySet()){
            String mail = entry.getKey();
            int node = ds.find(mailMap.get(mail));
            mergedMail[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for ( int i=0; i<n; i++){
            if ( mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(mergedMail[i]);
            res.add(account);
        }

        return res;

    }

    static class DisjointSet{
        private List<Integer> parent = new ArrayList<>();
        private List<Integer> rank = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<=n ; i++){
                parent.add(i);
                rank.add(0);
            }
        }

        public int find(int node){
            if ( node == parent.get(node)) return node;
            else {
                int uParent = find(parent.get(node));
                parent.set(node, uParent);
                return uParent;
            }
        }

        public void union(int u, int v){
            int uParent = find(u);
            int vParent = find(v);
            if ( uParent == vParent) return;
            if ( rank.get(uParent) < rank.get(vParent)) {
                parent.set(uParent, vParent);
            } else if (rank.get(uParent) > rank.get(vParent)){
                parent.set(vParent, uParent);
            } else {
                parent.set(vParent, uParent);
                int uRank = rank.get(uParent);
                rank.set(uParent, uRank+1);
            }
        }
    }
}
