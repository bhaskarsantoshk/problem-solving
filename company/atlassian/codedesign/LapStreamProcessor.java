package company.atlassian.codedesign;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * LapStreamProcessor
 * - ingestLap(driverId, lapTime): called for every lap in the stream
 * - getTopDriverByGap(): returns the driver whose latest lap is farthest below the global average (largest avg - lap)
 */
public class LapStreamProcessor {

    // concurrent containers
    private final ConcurrentMap<String, Double> latestLapByDriver = new ConcurrentHashMap<>();
    private final DoubleAdder globalSum = new DoubleAdder();
    private final LongAdder globalCount = new LongAdder();

    public LapStreamProcessor() { }

    /**
     * Ingest a lap reading.
     * Thread-safe.
     */
    public void ingestLap(String driverId, double lapTime) {
        if (driverId == null) throw new IllegalArgumentException("driverId null");
        if (Double.isNaN(lapTime) || Double.isInfinite(lapTime)) throw new IllegalArgumentException("invalid lapTime");

        latestLapByDriver.put(driverId, lapTime);
        globalSum.add(lapTime);
        globalCount.increment();
    }

    /**
     * Compute current global average.
     */
    public OptionalDouble getGlobalAverage() {
        long cnt = globalCount.sum();
        if (cnt == 0) return OptionalDouble.empty();
        return OptionalDouble.of(globalSum.sum() / (double) cnt);
    }

    /**
     * TopDriver record returned by getTopDriverByGap()
     */
    public static record TopDriver(String driverId, double gap, double latestLap, double globalAvg) { }

    /**
     * Return the single driver whose latest lap is farthest below the global average.
     * gap = globalAvg - latestLap. Only positive gaps (i.e., laps faster than avg) are considered.
     * If no laps seen or no driver is faster than the average, returns Optional.empty().
     */
    public Optional<TopDriver> getTopDriverByGap() {
        OptionalDouble maybeAvg = getGlobalAverage();
        if (maybeAvg.isEmpty()) return Optional.empty();
        double avg = maybeAvg.getAsDouble();

        String bestDriver = null;
        double bestGap = Double.NEGATIVE_INFINITY;
        double bestLatestLap = Double.NaN;

        for (Map.Entry<String, Double> e : latestLapByDriver.entrySet()) {
            double latest = e.getValue();
            double gap = avg - latest; // positive if driver is faster than avg
            if (gap > bestGap && gap > 0.0) {
                bestGap = gap;
                bestDriver = e.getKey();
                bestLatestLap = latest;
            }
        }

        if (bestDriver == null) return Optional.empty();
        return Optional.of(new TopDriver(bestDriver, bestGap, bestLatestLap, avg));
    }

    // Diagnostics
    public Map<String, Double> snapshotLatestLaps() {
        return Collections.unmodifiableMap(new HashMap<>(latestLapByDriver));
    }

    public Map<String, Number> snapshotGlobalStats() {
        Map<String, Number> m = new HashMap<>();
        m.put("count", globalCount.sum());
        m.put("sum", globalSum.sum());
        getGlobalAverage().ifPresent(avg -> m.put("avg", avg));
        return Collections.unmodifiableMap(m);
    }

    // Demo
    public static void main(String[] args) throws InterruptedException {
        LapStreamProcessor processor = new LapStreamProcessor();

        List<String> drivers = List.of("DR1", "DR2", "DR3", "DR4");
        double[][] sampleLaps = {
                {72.3, 71.9, 72.1},
                {70.5, 70.8, 70.7},
                {73.0, 72.7, 72.5},
                {71.0, 71.1, 71.3}
        };

        ExecutorService producers = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(drivers.size());

        for (int i = 0; i < drivers.size(); i++) {
            final String driver = drivers.get(i);
            final double[] laps = sampleLaps[i];
            producers.submit(() -> {
                try {
                    for (double lap : laps) {
                        processor.ingestLap(driver, lap);
                        Thread.sleep(ThreadLocalRandom.current().nextInt(10, 50));
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        producers.shutdown();

        System.out.println("Global stats: " + processor.snapshotGlobalStats());
        System.out.println("Latest laps: " + processor.snapshotLatestLaps());
        Optional<TopDriver> top = processor.getTopDriverByGap();
        top.ifPresentOrElse(
                td -> System.out.printf("Top driver by gap: %s (gap=%.4f, latest=%.3f, avg=%.4f)%n",
                        td.driverId(), td.gap(), td.latestLap(), td.globalAvg()),
                () -> System.out.println("No driver is faster than global average or no data.")
        );
    }
}