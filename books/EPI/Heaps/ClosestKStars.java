package books.EPI.Heaps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosestKStars {
    public static List<Star> getClosestKStars(Iterator<Star> stars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while (stars.hasNext()) {
            maxHeap.add(stars.next());
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return Stream.generate(maxHeap::remove).limit(maxHeap.size()).collect(Collectors.toList());
    }

    private static class Star implements Comparable<Star> {
        private double x, y, z;

        public Star(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star that) {
            return Double.compare(this.distance(), that.distance());
        }
    }
}

// O (N log K) Time, O(K) Space
