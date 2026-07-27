public class GarbageCollectionDemo {

    private static class DemoObject {
        private final String label;
        private final byte[] payload = new byte[128];

        DemoObject(String label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Garbage Collection Demonstration =====");
        long startTime = System.nanoTime();

        MemoryMonitor.printMemoryReport("Before Allocation");

        DemoObject[] objects = new DemoObject[100000];
        System.out.println("Creating Objects...");
        // TODO: fill objects[i] = new DemoObject("Object-" + i)
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new DemoObject("Object-" + 1);
        }
        // TODO: print Objects Created count; printMemoryReport After Allocation
        System.out.printf("Objects Created: %d%n", objects.length);
        MemoryMonitor.printMemoryReport("After Allocation");
        // TODO: set objects = null; trigger GC; print After GC report + elapsed ms
        objects = null;
        MemoryMonitor.triggerGarbageCollection();
        MemoryMonitor.printMemoryReport("After GC");
        long elapsedMillis = (System.nanoTime() - startTime) / 1_000_000;
        System.out.printf("Elapsed Time: %d ms%n", elapsedMillis);
        // Tip: elapsedMillis = (System.nanoTime() - startTime) / 1_000_000
        throw new UnsupportedOperationException("TODO");
    }
}