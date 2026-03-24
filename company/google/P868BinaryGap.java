package company.google;

public class P868BinaryGap {
    public int binaryGap(int n) {
        int max_distance = 0, prev = -1, curr = n;

        while (curr != 0) {
            int pos = Integer.numberOfTrailingZeros(curr);

            if (prev != -1) {
                int distance = pos - prev;
                max_distance = Math.max(max_distance, distance);
            }

            prev = pos;

            curr = curr & (curr - 1);
        }

        return max_distance;
    }
}
