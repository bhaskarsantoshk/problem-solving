class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for ( int i=1; i<=numRows; i++){
            result.add(generateRow(i));
        }
        return result;
    }

    private List<Integer> generateRow ( int row ){
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int ans = 1;
        for ( int i=1; i<row; i++){
            ans = ans * (row-i);
            ans = ans/i;
            res.add(ans);
        }
        return res;
    }
}
