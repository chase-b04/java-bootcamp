Command:
java -XX:+UseG1GC -Xms16m -Xmx64m -Xlog:gc GcObserve

Evidence:
The log began with "Using G1" and showed G1 evacuation pauses.
The collector flag selects G1; it does not guarantee a particular pause time.

Command:
java -XX:+UseZGC -Xms16m -Xmx64m -Xlog:gc GcObserve

Evidence:
The log began with "Using The Z Garbage Collector" instead of "Using G1".
Pause-related log lines look different — ZGC does most of its work concurrently,
so it does not report the same kind of stop-the-world "Evacuation Pause" G1 does.

loaded RetentionDemo class
→ static CACHE field
→ ArrayList entries
→ byte[] objects

Exercise 7
| Run | String ms | StringBuilder ms |
| --- | --------- | ---------------- |
| 1   | 298218400 | 2625700 |
| 2   | 169997900 | 2171900 |
| 3   | 174827700 | 1983800 |