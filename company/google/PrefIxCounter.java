package company.google;

public class PrefIxCounter {
    public static int countPrefixWords(String[] array, String prefix) {
        int start = findStartingOfPrefix( array, prefix);
        int end = findEndingOfPrefix(array, prefix);
        // If the prefix is not found, return 0
        if (start == -1 || end == -1 || start > end) return 0;

        return end - start + 1;
    }

    private static int findEndingOfPrefix(String[] array, String prefix) {
        int start = 0, end = array.length-1;
        int ans = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( array[mid].startsWith(prefix) ) {
                ans = mid;
                start = mid+1;
            } else if ( array[mid].compareTo(prefix) > 0 ) end = mid-1;
            else start = mid+1;
        }
        return ans;
    }

    private static int findStartingOfPrefix(String[] array, String prefix) {
        int start = 0, end = array.length-1;
        int ans = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( array[mid].startsWith(prefix) ) {
                ans = mid;
                end = mid-1;
            } else if ( array[mid].compareTo(prefix) > 0 ) end = mid-1;
            else start = mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] array = {"bomb", "book", "g", "gift", "go", "goal", "goat", "gum", "xray", "yellow", "zebra"};
        String prefix = "go";
        System.out.println(countPrefixWords(array, prefix)); // Output: 3
    }
}
