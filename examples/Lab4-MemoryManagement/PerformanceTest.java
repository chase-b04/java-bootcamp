public class PerformanceTest {

    private static class SampleObject {
        private final int value;
        private final byte[] data = new byte[64];

        SampleObject(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Performance Measurement =====");
//        MemoryMonitor.printMemoryReport("Start");

        int[] objectCounts = {10, 100, 1_000, 100_000, 1_000_000};

        System.out.println();
        System.out.printf("%-12s %-14s %-18s%n", "Objects", "Used Memory", "Execution Time");
        System.out.println("--------------------------------------------------");

        for (int count : objectCounts) {
            runAllocationTest(count);
        }

        System.out.println();
        System.out.println("Additional measurements:");
        measureLoopExecution();
        measureArrayAllocation();
        measureLargeByteArray();
    }

    private static void runAllocationTest(int count) {
        MemoryMonitor.triggerGarbageCollection();
        long memoryBefore = MemoryMonitor.getUsedMemoryBytes();
        long start = System.nanoTime();

        // TODO: allocate SampleObject[count], fill each slot
        SampleObject[] objects = new SampleObject[count];
        for (int i = 0; i < count; i++) {
            objects[i] = new SampleObject(i);
        }

        // TODO: measure elapsed ms + memoryUsed; printf row; null array + GC
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
        long memoryUsed = MemoryMonitor.getUsedMemoryBytes() - memoryBefore;
        System.out.printf("%-12d %-9.2f MB %d ms%n", count, MemoryMonitor.toMegabytesDouble(memoryUsed), elapsedMillis);
        objects = null;
        MemoryMonitor.triggerGarbageCollection();
//        throw new UnsupportedOperationException("TODO");
    }

    private static void measureLoopExecution() {
        // TODO: loop 10_000_000 iterations summing i into sum; print elapsed ms
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += i;
        }
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("Loop execution (10M iterations) : %d ms | sum = %d%n", elapsedMillis, sum);
//        throw new UnsupportedOperationException("TODO");
    }

    private static void measureArrayAllocation() {
        // TODO: allocate int[1_000_000], fill with i, print elapsed ms
        long start = System.nanoTime();
        int[] values = new int[1_000_000];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("int[1,000,000] allocation: %d ms%n", elapsedMillis);
//        throw new UnsupportedOperationException("TODO");
    }

    private static void measureLargeByteArray() {
        MemoryMonitor.printMemoryReport("Before Large byte[]");
        // TODO: allocate 10 MB byte[]; print After report; null + GC; print After Releasing
        byte[] data = new byte[10 * 1024 * 1024];
        MemoryMonitor.printMemoryReport("After Allocation");
        data = null;
        MemoryMonitor.triggerGarbageCollection();
        MemoryMonitor.printMemoryReport("After GC");
//        throw new UnsupportedOperationException("TODO");
    }
}
