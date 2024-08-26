package company.microsoft.others;

public class P171ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        // A - 1 ( 'A'-'A'+1 )
        // B - 2 ( 'B'-'A'+1)
        // AA - 26* 1 + 1

        int res = 0;
        for ( char c: columnTitle.toCharArray()){
            res = res * 26 + (c-'A'+1);
        }
        return res;
    }
}
