public class StringBuilderComparison {
    private static final int ITERATIONS = 50_000;

    static String withString() {
        String result = "";
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result += "x";  (each update creates another String)
            result += "x";
        }
        return result;
    }

    static String withBuilder() {
        // Initial capacity avoids repeated buffer growth.
        // TODO: StringBuilder result = new StringBuilder(ITERATIONS);
        StringBuilder result = new StringBuilder(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            // TODO: result.append('x');
            result.append('x');
        }
        // TODO: return result.toString();
        return result.toString();
    }

    public static void main(String[] args) {
        // TODO: time withString() with System.nanoTime()
        long start = System.nanoTime();
        String str = withString();
        long end = System.nanoTime();
        long stringTime = end - start;
        // TODO: time withBuilder() with System.nanoTime()
        long start2 = System.nanoTime();
        String build = withBuilder();
        long end2 = System.nanoTime();
        long buildTime = end2 - start2;

        int stringLength = str.length();
        int buildLength = build.length();
        // TODO: printf both lengths and ms (stringNanos / 1_000_000.0)
        System.out.printf("String: %d chars, %d ms%n", stringLength, stringTime);
        System.out.printf("StringBuilder: %d chars, %d ms%n", buildLength, buildTime);
    }
}