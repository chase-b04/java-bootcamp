

E5:
map produced a new list of proposed values; it did not modify the immutable Employee records in the source list.

E6
Why: Downstream collectors change what each group stores.

Answer in notes.md:

Why is the value type Long, not Integer?
What would the values contain if you removed Collectors.counting()?
Why is a TreeMap used only for presentation here?
Suggested direction: collector counts use Long; plain groupingBy produces lists; the original aggregation does not require sorted keys.


E8

Why: Shared mutable counters lose updates under concurrent workers.

Do not write:

int[] count = {0};
employees.parallelStream().forEach(employee -> count[0]++);
Explain in notes.md: multiple worker threads can update the same mutable value concurrently and lose updates. Use the built-in count() reduction.