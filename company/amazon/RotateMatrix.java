public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        for ( ArrayList<Integer> al: a){
            int start = 0;
            int end = al.size()-1;
            while(start < end ){
                int temp = al.get(start);
                al.set(start, al.get(end));
                al.set(end, temp);
                start++;
                end--;
            }
        }
    }

    private void transpose(ArrayList<ArrayList<Integer>> a) {
        for ( int i=0; i<a.size(); i++){
            for ( int j=0; j<i; j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }
}
